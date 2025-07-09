package org.hbkj.springbootmybatis;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsDao {
    public int insert(GoodsDo goodsDo);
    public int delete(Long id);
    public int update(GoodsDo goodsDo);
    public GoodsDo selectOne(Long id);
    public List<GoodsDo> selectAll();
    @Update("UPDATE lgoods SET count = count - #{quantity} WHERE id = #{id}")
    int reduceStock(@Param("id") Long id, @Param("quantity") int quantity);

    @Select("SELECT * FROM lgoods WHERE count = 0")
    List<GoodsDo> getLowStockGoods();

    // 根据 ID 和价格查询商品
    @Select("SELECT * FROM lgoods WHERE id = #{id} AND price = #{price}")
    GoodsDo findByIDAndPrice(@Param("id") Long id, @Param("price") String price);

    // 更新库存数量
    @Update("UPDATE lgoods SET count = #{newCount} WHERE id = #{id} AND price = #{price}")
    int updateCount(@Param("id") Long id, @Param("price") String price, @Param("newCount") String newCount);
}
