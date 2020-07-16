package com.project.controller;


import com.github.pagehelper.PageInfo;
import com.project.common.Msg;
import com.project.pojo.Admin;
import com.project.pojo.AdminPermissions;
import com.project.pojo.Permissions;
import com.project.service.AdminPermissionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
public class AdminPermissionController {

    @Autowired
    private AdminPermissionsService adminPermissionsService;

    @RequestMapping("/permission/toAdminPermissions")
    public String selectAdminPermissions(Model model, HttpServletRequest request)
    {
        Admin admin = (Admin)request.getSession().getAttribute("admin");
        Integer id = admin.getId();
        List<AdminPermissions> list = adminPermissionsService.selectAdminPermissionsById(id);
        List<String> permissionsList = list.stream().map(AdminPermissions::getPermission).collect(Collectors.toList());
       /* System.out.println(permissionsList);
        System.out.println(permissionsList.contains("admin:userInfoElse"));*/
        PageInfo<String> pageInfo = new PageInfo<String>(permissionsList);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("permissionsList",permissionsList);
        model.addAttribute("activeUrl","indexActive");
        model.addAttribute("activeUrl1","permissionActive");
        model.addAttribute("activeUrl2","adminPermissionsActive");

        return "admin/permission/adminpermissions";
    }

    @RequestMapping("/updateAdminPermissions")
    @ResponseBody

    public Msg updateAdminPermissions(@RequestParam("adminPermissions") String permissions){
        int j = 1;
        String [] array = permissions.split(";");
        List<Integer> integerList = new ArrayList<Integer>();
        for (int i = 0;i < array.length; i++){
            integerList.add(adminPermissionsService.selectPermissionId(array[i]));
        }
        adminPermissionsService.deleteAdminPermissionsAll(1);
        AdminPermissions adminPermissions = new AdminPermissions();
        adminPermissions.setAdminId(1);
        Iterator iterator = integerList.iterator();
        while(iterator.hasNext()){
            adminPermissions.setPermissionId((Integer) iterator.next());
            int i  = adminPermissionsService.insertAdminPermissions(adminPermissions);
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
