<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../../resources/pages/pagebase.jsp"%>
<%@include file="../../resources/pages/gridbase.jsp"%>
<script type="text/babel">

window.WMGridTitle = React.createClass({	
	render: function() {	
		return (
			<tr className="listHeader">
				<td>項次</td>
				<td>參數名稱</td>
				<td>參數數值</td>
				<td>參數描述</td>
			</tr>
		);
	}
});

window.WMGridRow = React.createClass({		
	render: function() {
		var dataMap = this.props.dataMap;				
		return (
			<tr className={this.props.trClass}  >
				<td>{this.props.index}</td>
				<td>{dataMap.CONFIG_NAME}</td>
				<td>{dataMap.CONFIG_VALUE}</td>
				<td>{dataMap.CONFIG_DESCRIPTION}</td>
			</tr>
		);
	}
});

ReactDOM.render(
  <WMSearchForm />,
  document.getElementById('WMSearchForm')
);
</script>

<script type="text/javascript">
	
</script>


<div id="content">
<form id="WMSearchForm">	
</form>
</div>
