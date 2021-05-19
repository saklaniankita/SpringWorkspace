<html>
<head>
<title>Spring ModelAttribute Example</title>
</head>
<body>
<h2>.................... ${msg} ................. </h2>
<table width="372" border="0">
  <tr>
    <td width="125">Reg.No</td>
    <td width="231">${ob.regno} </td>
  </tr>
  <tr>
    <td>Name</td>
    <td>${ob.sname}</td>
  </tr>
  <tr>
    <td>Course</td>
    <td>${ob.course} </td>
  </tr>
  <tr>
    <td>City</td>
    <td>${ob.addressBean.city} </td>
  </tr>
  <tr>
    <td>State</td>
    <td>${ob.addressBean.state} </td>
  </tr>
  <tr>
    <td>Pincode</td>
    <td>${ob.addressBean.pincode} </td>
  </tr>
</table>
</body>
</html>