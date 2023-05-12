package com.example.spring01.gateway;

import com.example.spring01.gateway.dto.GatewayListDto;
import com.example.spring01.gateway.dto.GatewaySaveDto;
import com.example.spring01.gateway.dto.GatewaySearchCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class GatewayController {

    private final GatewayService gatewayService;


    @GetMapping("/gateway/list")
    public String gatewayList(GatewaySearchCondition condition,
                              @RequestParam(value="page", defaultValue="0") String page,
                              @RequestParam(value="size", defaultValue="10") String size,
                              Model model) throws Exception {

        int pageNumber = 0;
        int pageSize = 10;

        try {
            pageNumber = Integer.parseInt(page);
            pageSize = Integer.parseInt(size);
        } catch (NumberFormatException e) {
            // 잘못된 값을 입력받은 경우, 적절한 예외 처리를 수행하고, 사용자에게 알림을 전달합니다.
            model.addAttribute("alertMsg", "잘못된 요청입니다.");
            model.addAttribute("redirectUrl", "/gateway/list?page=0&size=10");
            return "error/modal";
        }

        PageRequest pageable = PageRequest.of(pageNumber, pageSize);
        Page<GatewayListDto> lists = gatewayService.searchFindAllV3(condition, pageable);

        // 게시물 카운터
        long TotalElements = lists.getTotalElements();
        // 게시물 순번, ID 번호 아님
        long TotalNum = TotalElements - (long) lists.getNumber() * lists.getSize();

        model.addAttribute("lists", lists);
        model.addAttribute("TotalNum", TotalNum);
        model.addAttribute("TotalElements", TotalElements);

        model.addAttribute("GatewaySearchCondition", condition);
        model.addAttribute("pageRange", 10);

        return "gateway/gatewayList";
    }


    @GetMapping("/gateway/form")
    public String gatewayForm(GatewaySaveDto gatewaySaveDto, Model model) {

        model.addAttribute("gatewaySaveDto", gatewaySaveDto);

        return "gateway/gatewayForm";
    }


    @PostMapping("/gateway/form")
    public String gatewayFormProc(@Validated @ModelAttribute GatewaySaveDto gatewaySaveDto,
                                  BindingResult result,
                                  Model model) throws Exception {
        // 여러개의 에러 처리
//        if(result.hasErrors()) {
//            Map<String, String> errors = new HashMap<>();
//            for(FieldError error : result.getFieldErrors()) {
//                errors.put(error.getField(), error.getDefaultMessage());
//
//            }
//            model.addAttribute("errors", errors);
//            return "gateway/gatewayForm";
//        }

        // 단일 에러만 출력
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            FieldError firstError = result.getFieldErrors().get(0);
            errors.put(firstError.getField(), firstError.getDefaultMessage());

            model.addAttribute("errors", errors);
            return "gateway/gatewayForm";
        }


        gatewayService.saveGatewayV1(gatewaySaveDto);

        return "redirect:/gateway/list";
    }
}
