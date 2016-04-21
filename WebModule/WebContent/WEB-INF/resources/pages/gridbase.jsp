<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
	function selectGridTool(value) {
		console.log(value);
		//$("#searchPageSize").
		$("#seachPageNum").val(value);
		$("#WMSearchForm").submit();
	}
	
	function searchSumbit() {
		console.log("submit");
	}
</script>

<script type="text/babel">
window.WMGridTool = React.createClass({
	render: function() {		
		return (
			<div>						
				<a href="javascript:void(0);"><img src="<c:url value="/resources/images/gridtool/page-first.gif" />" /></a>
				<a href="javascript:void(0);"><img src="<c:url value="/resources/images/gridtool/page-prev.gif" />" /></a>
				<WMGridToolSelect pageTotal={this.props.pageTotal} pageNumber={this.props.pageNumber} />
				/{this.props.pageTotal}頁，共{this.props.pageTotalCount}筆
				<a href="javascript:void(0);"><img src="<c:url value="/resources/images/gridtool/page-next.gif" />" /></a>
				<a href="javascript:void(0);"><img src="<c:url value="/resources/images/gridtool/page-last.gif" />" /></a>
			</div>
		);
	}
});

window.WMGridToolSelect = React.createClass({

	selectHandler:function(e) {
		//this.options[this.selectedIndex].value		
		selectGridTool(e.target.options[e.target.selectedIndex].value);
	},

	render: function() {
		
		var optionRows = [];
		for (var i=1; i <= this.props.pageTotal; i++) {
			if (i == this.props.pageNumber) {
				optionRows.push(<option value={i} selected>{i}</option>);
			} else {
				optionRows.push(<option value={i}>{i}</option>);
			}
    		
		}

		return(
			React.createElement("select", {onChange:this.selectHandler, name:"gridtoolSelect"}
				,optionRows
			)			
		);
	}

});

//data命名與傳輸方式待確認
window.WMGridBlock = React.createClass({
	render: function() {

		var data = ${data};
		//console.log(data);
		var dataNodes = data.pageData.map(function(dataMap, index) {
			
			var trClass = "listColor01";
			if (index%2 != 0) {
				trClass = "listColor02"
			}
									
			return (
				<WMGridRow dataMap={dataMap} index={index+1} trClass={trClass} />
			);
		});
		
		return (
			<div id="WMGridBlock">						
				<WMGridTool pageTotal={data.pageTotal} pageNumber={data.pageNumber} pageTotalCount={data.pageTotalCount} />
				<table className="box1" >
					<WMGridTitle />
					{dataNodes}
				</table>
				<WMGridTool pageTotal={data.pageTotal} pageNumber={data.pageNumber} pageTotalCount={data.pageTotalCount} />
			</div>
		);
	}
});

window.WMSearchForm = React.createClass({
	render: function() {				
		return (
			<div>
			<form id="WMSearchForm" action={this.props.action} method="post" >	
				<input type="hidden" name="pageSize" id="searchPageSize" value="10"/>
				<input type="hidden" name="pageNum" id="seachPageNum" />
				<WMSearchBlock />
			</form>
				<WMGridBlock />
			</div>	
		);
	}
});

window.WMSearchBlock = React.createClass({
	render: function() {		
		return (
			<div id="WMSearchBlock" className="panelSearch" >						
				<WMSearchTable />
			</div>
		);
	}
});

window.WMSearchButton = React.createClass({
	render: function() {		
		return (
			<div className="btnarea">
				<div className="list_btn">
					<button type={this.props.type}>{this.props.value}</button>
				</div>
			</div>
		);
	}
});
</script>