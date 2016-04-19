<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script type="text/babel">

window.CommentGridData = React.createClass({
	getInitialState: function() {
		console.log(this.props.message);
		return {data: {pageData:[]}};
	},
	
	componentDidMount: function() {
		$.ajax({
			url: this.props.dataurl,	  
			dataType: 'json',
			data:$('#CommentGridForm').serialize(),
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
		$("#CommentGridForm").attr("method", this.props.method);
		$("#CommentGridForm").attr("action", this.props.action);
		$("#CommentGridForm").submit();
	},


	render: function() {
		return (
			<div className="commentBox">
				<h1>Comments</h1>
				
				<CommentGridForm sumbitFunction={this.handleSubmit} />
				
				<CommentGridRow data={this.state.data} />				
			</div>
		);
	}
});



var CommentGridForm = React.createClass({
  render: function() {

    return (
		<form id="CommentGridForm" onSubmit={this.props.sumbitFunction}>      
        <input type="text" placeholder="pageSize" name="pageSize" />
        <input type="text" placeholder="pageNum" name="pageNum" />
        <button type="submit">go</button>
		</form>      
    );
  }
});


</script>
