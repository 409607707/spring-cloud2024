package com.atguigu.cloud.apis;

import com.atguigu.cloud.entity.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("cloud-payment-service")
public interface PayFeignApi {
  /**
   * 新增一条支付相关流水记录
   * @param payDTO
   * @return
   */
  @PostMapping("/pay/add")
  ResultData addPay(@RequestBody PayDTO payDTO);

  /**
   * 按照主键记录查询支付流水信息
   * @param id
   * @return
   */
  @GetMapping("/pay/get/{id}")
  ResultData getPayInfo(@PathVariable("id") Integer id);

  /**
   * 用来测试OpenFeign天生支持LoadBalancer负载均衡
   * openfeign天然支持负载均衡演示
   * @return
   */
  @GetMapping("/pay/get/info")
  String myLb();

}
