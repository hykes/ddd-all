package com.github.hykes.ui.front;

import com.github.hykes.bean.request.CustomerCreateRequest;
import com.github.hykes.bean.request.CustomerFindByIdRequest;
import com.github.hykes.bean.response.CustomerInfo;
import com.github.hykes.facade.CustomerReadFacade;
import com.github.hykes.facade.dto.NewsCategoryDTO;
import com.github.hykes.response.Response;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author hehaiyangwork@gmail.com
 * @date 2019-02-28 20:48:00
 */
@RestController
@RequestMapping("api/categories")
public class NewsCategoryController {

    @Reference(version = "1.0.0", url = "dubbo://127.0.0.1:20884")
    private CustomerReadFacade customerReadFacade;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Integer> create(@RequestBody CustomerCreateRequest request) {
        return Response.ok(1);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<CustomerInfo> getById(@PathVariable("id") Long id) {

        CustomerFindByIdRequest request = CustomerFindByIdRequest.builder().id(id).build();
        customerReadFacade.findById(request);
        return Response.ok(new CustomerInfo());
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Void> update(@PathVariable("id") Long id,
                                 @RequestBody NewsCategoryDTO updater) {
        return Response.ok(null);
    }

    @PutMapping(value = "{id}/enable", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Void> enable(@PathVariable("id") Long id) {
        return Response.ok(null);
    }

    @PutMapping(value = "{id}/disable", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response<Void> disable(@PathVariable("id") Long id) {
        return Response.ok(null);
    }

}
