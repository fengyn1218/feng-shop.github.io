package cn.feng.my.shop.web.api.dao;

import cn.feng.my.shop.domain.TbContent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TbContentDao {
    //根据类别ID查询内容列表
    List<TbContent> selectByCategoryId(TbContent tbContent);
}
