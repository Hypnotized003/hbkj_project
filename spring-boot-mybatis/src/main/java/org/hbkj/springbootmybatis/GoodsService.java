package org.hbkj.springbootmybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * 商品服务类，封装对商品的操作
 * */
@Service
public class GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    /**
     * 新增商品
     * */
    public void add(GoodsDo goodsDo){
        goodsDao.insert(goodsDo);
    }
    /**
     * 删除商品
     * */
    public void remove(Long id){
        goodsDao.delete(id);
    }
    /**
     * 编辑商品信息
     * */
    public void edit(GoodsDo goodsDo){
        goodsDao.update(goodsDo);
    }
    /**
     * 按id获取商品信息
     * */
    public GoodsDo getById(Long id){
        return goodsDao.selectOne(id);
    }
    /**
     * 获取商品信息列表
     * */
    public List<GoodsDo> getAll(){
        return goodsDao.selectAll();
    }

    public void reduceStock(Long id, int quantity) {
        goodsDao.reduceStock(id, quantity);
    }

    public List<GoodsDo> ZeroStock() {
        return goodsDao.getLowStockGoods();
    }

    public void addOrUpdateGoods(GoodsDo goodsDo) {
        // 检查是否存在相同的商品 ID 和价格
        GoodsDo existingGoods = goodsDao.findByIDAndPrice(goodsDo.getId(), goodsDo.getPrice());
        if (existingGoods != null) {
            // 如果存在，更新库存数量
            int existingCount = Integer.parseInt(existingGoods.getCount());
            int newQuantity = existingCount + Integer.parseInt(goodsDo.getCount());
            goodsDao.updateCount(goodsDo.getId(), goodsDo.getPrice(), String.valueOf(newQuantity));
        } else {
            // 如果不存在，插入新的商品
            goodsDao.insert(goodsDo);
        }
    }

}