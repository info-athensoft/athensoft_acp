package com.athensoft.ecomm.order.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.athensoft.ecomm.order.entity.Order;
import com.athensoft.ecomm.order.entity.OrderItem;
import com.athensoft.ecomm.order.service.OrderItemService;
import com.athensoft.ecomm.order.service.OrderService;

@Controller
public class OrderController {
	
	private static final Logger logger = Logger.getLogger(OrderController.class);
	
	private OrderService orderService;
	
	@Autowired
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	private OrderItemService orderItemService;

	@Autowired
	public void setOrderItemService(OrderItemService orderItemService) {
		this.orderItemService = orderItemService;
	}

	@RequestMapping(value="/ecomm/orders")
	public String gotoOrders(){
		String viewName = "order/ecomm_orders";
		return viewName;
	}
	
	@RequestMapping("/ecomm/ordersview")
	public String gotoOrdersView(){
		String viewName = "order/ecomm_orders_view";
		return viewName;
	}
	
	
	@RequestMapping(value="/orders")
	public ModelAndView getAllOrders(){
		ModelAndView mav = new ModelAndView();
		
		List<Order> orders = orderService.getAllOrders();
		logger.info("size of orders:\t"+orders.size());
		
		Map<String,Object> data = mav.getModel();
		data.put("orderList", orders);		
		mav.setViewName("order/ecomm_orders");
		return mav;
	}
	
	
	/*
	@RequestMapping(value="/orders",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public List<Order> getAllOrders(){
		
		List<Order> orders = orderService.getAllOrders();
		System.out.println("size of orders:\t"+orders.size());
		return orders;
	}
	
	@RequestMapping(value="/orders",method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public List<OrderHead> getAllOrders2(){
		
		List<Order> orders = orderService.getAllOrders();
		System.out.println("size of orders:\t"+orders.size());
		
		List<OrderHead> orderheads = new ArrayList<OrderHead>();
		for(Order order:orders){
			OrderHead oh = new OrderHead();
			oh.setOrderId(order.getOrderId());
			oh.setOrderNo(order.getOrderNo());
			oh.setOrderDateTime(order.getOrderDateTime());
			oh.setGrandTotalAmount(order.getGrandTotalAmount());
			oh.setOrderStatus(order.getOrderStatus());
			oh.setPaymentMethod(order.getPaymentMethod());
			orderheads.add(oh);
		}
		return orderheads;
	}
	*/
	
	
	/**
	 * get order objects in JSON data form
	 * the data for showing in datatable in front-end pages is contained in a 2-dimension array
	 * @return a map structure containing data rendered to view
	 */
	@RequestMapping(value="/ecomm/orderListData",produces="application/json")
	@ResponseBody
	public Map<String,Object> getDataOrderList(){
		logger.info("entering /ecomm/orderListData");
		
		ModelAndView mav = new ModelAndView();
		
		//data
		List<Order> listOrders = orderService.getAllOrders();
		logger.info("size of orders:\t"+listOrders.size());
		
		String[][] data = getData(listOrders);
		
		Map<String, Object> model = mav.getModel();
		
		model.put("draw", new Integer(1));
		model.put("recordsTotal", new Integer(5));
		model.put("recordsFiltered", new Integer(5));
		model.put("data", data);
		model.put("customActionStatus","OK");
		model.put("customActionMessage","OK");
		
		logger.info("leaving /ecomm/orderListData");
		return model;
	}

	@RequestMapping(value="/ecomm/orders/{orderNo}")
	public ModelAndView getOrderDetail(@PathVariable String orderNo){
		logger.info("entering /ecomm/orders/{orderNo}");
		ModelAndView mav = new ModelAndView();
		
		Order order = orderService.getOrderByOrderNo(orderNo);
//		logger.info("getOrderDetail()\n"+order.toString());
		
		Map<String,Object> model = mav.getModel();
		model.put("order", order);
		mav.setViewName("order/ecommerce_orders_view");
		
		logger.info("existing /ecomm/orders/{orderNo}");
		return mav;
	}
	
	@RequestMapping(value="/ecomm/orderitems")
	public String testOrderItem(@RequestParam String orderNo){
		
		System.out.println("testOrderItem");
		
		List<OrderItem> list = orderItemService.getOrderItemsByOrderNo(orderNo);
		System.out.println("list.size="+list.size());
		
		return "order/ecomm_orders_view";
	}
	
	
	private String[][] getData(List<Order> listOrders){
		int entryLength = listOrders.size();
		final int COLUMN_NUM = 8;
		String[][] data = new String[entryLength][COLUMN_NUM];
		
		String field0 = "";	//check box
		String field1 = "";	//order no
		String field2 = "";	//order datetime
		String field3 = "";	//customer
		String field4 = "";	//ship to
		String field5 = ""; //grandTotalAmount
		String field6 = "";	//order status
		String field7 = "";	//action
		
		for(int i=0; i<entryLength ; i++){			
			field0 = "<input type='checkbox' name='id[]' value="+listOrders.get(i).getOrderId()+">";
			field1 = listOrders.get(i).getOrderNo()+"";
			field2 = listOrders.get(i).getOrderDateTime()+"";
			field3 = listOrders.get(i).getCustNo();
			field4 = listOrders.get(i).getCustNo();
			field5 = listOrders.get(i).getGrandTotalAmount()+""; 
			
			int intOrderStatus = listOrders.get(i).getOrderStatus();
			String orderStatus = "";
			String orderStatusKey = "";
			switch(intOrderStatus){
				case Order.TRANS_STATUS_CREATED: 
					orderStatus = "Created";
					orderStatusKey = "success";
					break;
				case Order.TRANS_STATUS_PROCESSING:
					orderStatus = "Processing";
					orderStatusKey = "success";
					break;
				case Order.TRANS_STATUS_PENDING:
					orderStatus = "Pending";
					orderStatusKey = "success";
					break;
				case Order.TRANS_STATUS_COMPLETED:
					orderStatus = "Completed";
					orderStatusKey = "success";
					break;
				case Order.TRANS_STATUS_CANCELED:
					orderStatus = "Canceled";
					orderStatusKey = "success";
					break;
				case Order.TRANS_STATUS_FRAUD:
					orderStatus = "Fraud";
					orderStatusKey = "success";
					break;
				default: 
					break;
			}
			field6 = "<span class='label label-sm label-"+orderStatusKey+"'>"+orderStatus+"</span>";
			field7 = "<a href='/acp/ecomm/orders/"+field1+"' class='btn btn-xs default btn-editable'><i class='fa fa-pencil'></i> View</a>";
			
			data[i][0] = field0;
			data[i][1] = field1;
			data[i][2] = field2;
			data[i][3] = field3;
			data[i][4] = field4;
			data[i][5] = field5;
			data[i][6] = field6;
			data[i][7] = field7;
		}
		
		return data;
	}
		
}