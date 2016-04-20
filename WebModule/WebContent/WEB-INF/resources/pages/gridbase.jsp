<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script type="text/javascript">
	function selectGridTool(value) {
		console.log(value);
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
				<WMGridToolSelect />
				<a href="javascript:void(0);"><img src="<c:url value="/resources/images/gridtool/page-next.gif" />" /></a>
				<a href="javascript:void(0);"><img src="<c:url value="/resources/images/gridtool/page-last.gif" />" /></a>
			</div>
		);
	}
});

window.WMGridToolSelect = React.createClass({

	selectHandler:function(e) {		
		selectGridTool(e.target.options[e.target.selectedIndex].value);
	},

	render: function() {
		//this.options[this.selectedIndex].value
		return(

			React.createElement("select", {onChange:this.selectHandler}
				,<option value="1">1</option>,<option value="2">2</option>


			)
		);
	}

});

//data命名與傳輸方式待確認
window.WMGridBlock = React.createClass({
	render: function() {

		var data = ${data};
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
				<WMGridTool />
				<table className="box1" >
					<WMGridTitle />
					{dataNodes}
				</table>
				<WMGridTool />
			</div>
		);
	}
});

window.WMSearchForm = React.createClass({
	render: function() {				
		return (
			<div>						
				<WMSearchBlock />
				<WMGridBlock />
			</div>
		);
	}
});

window.WMSearchBlock = React.createClass({
	render: function() {		
		return (
			<div id="WMSearchBlock">						
				
			</div>
		);
	}
});


</script>