package com.project.controller;


import com.github.pagehelper.PageInfo;
import com.project.common.Msg;
import com.project.pojo.Admin;
import com.project.pojo.UserPermissions;
import com.project.service.UserPermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/admin")
public class UserPermissionsController {
    @Autowired
    private UserPermissionsService userPermissionsService;

    @RequestMapping("/permission/toUserPermissions")
    public String selectUserPermissions(Model model, HttpServletRequest request)
    {
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        Integer id = admin.getId();
        List<UserPermissions> list = userPermissionsService.selectUserPermissionsById(id);
        List<String> permissionsList = list.stream().map(UserPermissions::getPermission).collect(Collectors.toList());
       /* System.out.println(permissionsList);
        System.out.println(permissionsList.contains("admin:userInfoElse"));*/
        PageInfo<String> pageInfo = new PageInfo<String>(permissionsList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("permissionsList",permissionsList);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","permissionActive");
        model.addAttribute("activeUrl2","userPermissionsActive");

        return "admin/permission/userpermissions";
    }



    @RequestMapping("/updateUserPermissions")
    @ResponseBody

    public Msg updateUserPermissions(@RequestParam("userPermissions") String permissions){
        int j = 1;
        String [] array = permissions.split(";");
        List<Integer> integerList = new ArrayList<Integer>();
        for (int i = 0;i < array.length; i++){
            integerList.add(userPermissionsService.selectPermissionIdWithUser(array[i]));
        }
        userPermissionsService.deleteUserPermissionsAll(1);
        UserPermissions userPermissions = new UserPermissions();
        userPermissions.setUserId(1);
        Iterator iterator = integerList.iterator();
        while(iterator.hasNext()){
            userPermissions.setPermissionId((Integer) iterator.next());
            int i  = userPermissionsService.insertUserPermissions(userPermissions);
            if(i != j){
                j = 0;
            }
        }


        if(j == 1){
            return Msg.success();
        }else{
            return Msg.fail();
        }

    }
}
