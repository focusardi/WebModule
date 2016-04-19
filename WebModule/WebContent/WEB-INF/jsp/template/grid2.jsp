<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../resources/pages/pagebase.jsp"%>
<%@include file="../../resources/pages/gridbase.jsp"%>


<script type="text/babel">

window.CommentGridRow = React.createClass({
	render: function() {
		console.log(this.props.data);
		var commentNodes = this.props.data.pageData.map(function(comment) {
			return (
				<tr><td>{comment.CONFIG_NAME}</td><td>{comment.CONFIG_VALUE}</td><td>{comment.CONFIG_DESCRIPTION}</td></tr>
			);
		});
		//console.log(commentNodes);

		return (
			<table>
				{commentNodes}
			</table>
		);
	}
});

ReactDOM.render(
  <CommentGridData method="post" action="grid2" dataurl="gridData" message="${message}" />,
  document.getElementById('content')
);
</script>

<div id="content"></div>
