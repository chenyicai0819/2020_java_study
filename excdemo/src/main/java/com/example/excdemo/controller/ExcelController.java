package com.example.excdemo.controller;

import com.example.excdemo.bean.ReturnInfoUtil;
import com.example.excdemo.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
/**
 * @author George
 * @project excdemo
 * @package com.example.excdemo.controller
 * @date 2021/7/24 19:48
 * @since 1.0
 */



/**
 * Created by Luowenlv on 2018/9/10,15:29
 */
@Controller
public class ExcelController {
    @Autowired
    private ExcelService excelService;
    private ReturnInfoUtil returnInfoUtil;

    List userList = new ArrayList();

    @RequestMapping("/import")
    public String fileImport(@RequestParam("file") MultipartFile file,Model model) throws Exception {

        String fileName = file.getOriginalFilename();
        ReturnInfoUtil returnInfoUtil = excelService.getExcelInfo(fileName, file);
        model.addAttribute("retInfo",returnInfoUtil);
        return "info";
    }

    @RequestMapping("/loadPage")
    public String loadPage() {
        return "index";
    }


}