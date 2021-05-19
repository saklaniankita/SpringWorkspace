package com.candidjava.springmvc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
 
 
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
import com.candidjava.springmvc.bean.StudentBean;

//@Contoller
@RestController   // 4.0
@RequestMapping("/students")
public class RestStudentController
{
 
    // @ResponseBody  --> old since 3.0
     
    @RequestMapping(value="/list.abcd",method=RequestMethod.GET)
    public ResponseEntity<List<StudentBean>> contact()
    {
        List<StudentBean> sb=new ArrayList<StudentBean>();
         
        StudentBean sb1=new StudentBean();
        sb1.setSname("Raja");
        sb1.setRegno(1234);
         
        sb1.setCourse(Arrays.asList("Java", ".net"));
         
        StudentBean sb2=new StudentBean();
        sb2.setSname("Candid");
        sb2.setRegno(1235);
         
        sb2.setCourse(Arrays.asList("Php", ".net"));
         
         
        sb.add(sb1);
        sb.add(sb2);
         
        ResponseEntity<List<StudentBean>> rs=new ResponseEntity<List<StudentBean>>(sb, HttpStatus.OK);
         
        return rs;
    }
     
     
    @RequestMapping(value="/Register.abcd",method = RequestMethod.POST)
    public HttpStatus getFormData(@RequestBody StudentBean sb)
    {
    /*
        String u=request.getParameter("uname");
        String p=request.getParameter("pass");
            User user=new User();
            user.setUserName(u);
            user.setPassword(p);
    */
         
         
            System.out.println("Reg No..................." + sb.getRegno());
            System.out.println("Name..................." + sb.getSname());
            System.out.println("Course..................." + sb.getCourse());
        /*  System.out.println("City..................." + sb.getAddressBean().getCity());
            System.out.println("State..................." + sb.getAddressBean().getState());
            System.out.println("Pincode..................." + sb.getAddressBean().getPincode());*/
     
        /*  
            ModelAndView model = new ModelAndView("page");      
                    model.addObject("ob", sb); 
                    model.addObject("msg","Welcome");*/
    //  both will work it will automatically injected to on object
    //  model.addObject("msg", "Student Registration Details");
        return HttpStatus.CREATED; // 201
    }
}