<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../../resources/pages/pagebase.jsp"%>

<script type="text/babel">

var fakeData =  [
  {
    "id": 0,
    "name": "Mayer Leonard",
    "city": "Kapowsin",
    "state": "Hawaii",
    "country": "United Kingdom",
    "company": "Ovolo",
    "favoriteNumber": 7
  }
];


ReactDOM.render(
  <Griddle results={fakeData} />,
  document.getElementById('content')
);

</script>


<div id="content">

</div>
