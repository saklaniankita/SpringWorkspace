<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<body>
<h3 align="center">Student Registration Form</h3>
<form method="post" action="Register.abcd">
 
 	Reg no: <input type="text" name="regno" id="regno"> <br>
    Name: <input type="text" name="sname" id="sname"><br>
    Courses
      <label>
        <select name="course" id="course">
          <option value="J2SE">J2SE</option>
          <option value="J2EE">J2EE</option>
          <option value="Struts">Struts</option>
          <option value="Spring">Spring</option>
        </select>
      </label>
      <br>
      Address Details<br>
      
      City :<input type="text" name="addressBean.city" id="addressBean.city"><br>
      State : <input type="text" name="addressBean.state" id="addressBean.state"><br>
      Pincode: <input type="text" name="addressBean.pincode" id="addressBean.pincode"><br>
    
        <input type="submit" name="button" id="button" value="Register">
    </form>

</body>
</html>