package org.hbkj.springbootmybatis;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController//第一把GoodsController注册成了控制器，可以相应http请求，第二是可以将控制器中的方法返回值序列化为json数据格式
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    /**
     * 当库存为0时,显示在仪表盘中
     */
    @GetMapping("/goods/low-stock")
    public List<GoodsDo> getLowStockGoods() {
        return goodsService.ZeroStock();
    }

    @PutMapping("/goods/addOrUpdate")
    public void addOrUpdateGoods(@RequestBody GoodsDo goods) {
        goodsService.addOrUpdateGoods(goods);
    }

    @GetMapping("/goods/{id}")
    @Operation(summary = "获取商品信息",description = "使用id获取商品信息")
    public GoodsDo getOne(@PathVariable("id") long id){
        return goodsService.getById(id);
    }

    /**
     * 查询商品列表
     * */
    @GetMapping("/goods")
    public List<GoodsDo> getList(){
        return goodsService.getAll();
    }

    /**
     * 新增商品
     * */
    @PostMapping("/goods")
    public void add(@RequestBody GoodsDo goods){
        goodsService.add(goods);
    }

    /**
     * 修改商品
     * */
    @PutMapping("/goods/{id}")
    public void update(@PathVariable("id") long id, @RequestBody GoodsDo goods){
        goods.setId(id);
        goodsService.edit(goods);
    }
    /**
     * 删除商品
     * */
    @DeleteMapping("/goods/{id}")
    public void delete(@PathVariable("id") long id){
        goodsService.remove(id);
    }

    /**
     *结账的时候删除相应数量的商品
     */

    @PutMapping("/goods/reduceStock")
    public void reduceStock(@RequestBody List<StockUpdateRequest> requests) {
        for (StockUpdateRequest request : requests) {
            goodsService.reduceStock(request.getId(), request.getQuantity());
        }
    }



}