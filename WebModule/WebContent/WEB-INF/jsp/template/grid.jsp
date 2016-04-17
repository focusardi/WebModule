<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../resources/pages/pagebase.jsp"%>
<div id="griddiv"></div>
<div id="content"></div>
<script type="text/babel">

var CommentList = React.createClass({
  render: function() {
    
	//console.log(this.props.data);
	
	var commentNodes = this.props.data.map(function(comment) {
      return (
        <tr><td>{comment.CONFIG_NAME}</td><td>{comment.CONFIG_VALUE}</td></tr>
      );
    });
	//console.log(commentNodes);

    return (
      <table className="commentList">
      	{commentNodes}
      </table>
    );
  }
});

var CommentForm = React.createClass({
  render: function() {

console.log(this.props.sumbitFunction);
    return (
      <form className="commentForm" id="commentForm" >
        <input type="text" placeholder="pageSize" name="pageSize" />
        <input type="text" placeholder="pageNum" name="pageNum" />
        <input type="button" name="submit" onClick={this.props.sumbitFunction} />
      </form>
    );
  }
});

var CommentBox = React.createClass({
  getInitialState: function() {
    return {data: []};
  },
  componentDidMount: function() {
    $.ajax({
      url: this.props.url,	  
      dataType: 'json',
      cache: false,
      success: function(data) {
		console.log({data:data});		
        this.setState({data: data});
      }.bind(this),
      error: function(xhr, status, err) {
        console.error(this.props.url, status, err.toString());
      }.bind(this)
    });
  },

	handleSubmit:function(e) {
		$.ajax({
      url: this.props.url,
	  data:$('#commentForm').serialize(),
      dataType: 'json',
      cache: false,
      success: function(data) {
		console.log({data:data});		
        this.setState({data: data});
      }.bind(this),
      error: function(xhr, status, err) {
        console.error(this.props.url, status, err.toString());
      }.bind(this)
    });
	},


  render: function() {
    return (
      <div className="commentBox">
        <h1>Comments</h1>
        <CommentList data={this.state.data} />
        <CommentForm sumbitFunction={this.handleSubmit} />
      </div>
    );
  }
});

ReactDOM.render(
  <CommentBox url="gridData" pollInterval={2000} />,
  document.getElementById('content')
);
</script>