package cn.exrick.common.task;

import cn.exrick.mapper.TbOrderItemMapper;
import cn.exrick.mapper.TbOrderMapper;
import cn.exrick.mapper.TbOrderShippingMapper;
import cn.exrick.pojo.TbOrderExample;
import cn.exrick.pojo.TbOrderItemExample;
import cn.exrick.pojo.TbOrderShippingExample;
import cn.exrick.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Exrickx
 */
@Component
public class CancelOrderJob {

    final static Logger log= LoggerFactory.getLogger(CancelOrderJob.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private TbOrderMapper tbOrderMapper;

    @Autowired
    private TbOrderItemMapper tbOrderItemMapper;

    @Autowired
    private TbOrderShippingMapper tbOrderShippingMapper;

    /**
     * 每3个小时判断订单是否失效
     */
    @Scheduled(cron = "0 0 */3 * * ?")
    public void run() {

        log.info("开始执行自动取消订单定时任务");
        orderService.cancelOrder();
    }

    /**
     * 每月自动删除订单
     */
//    @Scheduled(cron = "0 0 0 0 1/1 ?")
//    public void deleteOrder() {
//
//        log.info("开始执行自动删除订单定时任务");
//        tbOrderMapper.deleteByExample(new TbOrderExample());
//        tbOrderItemMapper.deleteByExample(new TbOrderItemExample());
//        tbOrderShippingMapper.deleteByExample(new TbOrderShippingExample());
//    }
}
