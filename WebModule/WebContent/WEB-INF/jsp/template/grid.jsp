<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../resources/pages/pagebase.jsp"%>
<div id="griddiv"></div>
<script type="text/babel">
	var DataGrid = React.createClass({
		
		getInitialState: function() {
			return {
			CONFIG_NAME: 'init',
			CONFIG_VALUE: ''
			};
		},
		
		componentDidMount: function() {		
			this.serverRequest = $.get(this.props.source, function (result) {
				var jsonResult = $.parseJSON(result);
				//console.log(jsonResult);
				var firstData = jsonResult[0];
				this.setState({
					CONFIG_NAME: firstData.CONFIG_NAME,
					CONFIG_VALUE: firstData.CONFIG_VALUE
				});
			}.bind(this));
		},
		
		componentWillUnmount: function() {
			this.serverRequest.abort();
		},
		
		render: function() {
			return (<div>{this.state.CONFIG_NAME} : {this.state.CONFIG_VALUE}</div>);
		}
		
		
	});

	ReactDOM.render(
		<DataGrid source="gridData" />,
		document.getElementById("griddiv")
	);
</script>