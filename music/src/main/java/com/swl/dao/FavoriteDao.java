package com.swl.dao;

import com.swl.bean.Favorite;
import com.swl.utils.DBUtils;

import java.util.List;

public class FavoriteDao {
    //  添加收藏夹
    public boolean appendFavorite(Favorite favorite) {
        String sql = "insert into favorite(user_id,favorite_name,file_path,create_time) values(?,?,?,?)";
        return DBUtils.save(sql, favorite.getUserId(), favorite.getFavoriteName(), favorite.getFilePath(), favorite.getCreateTime());
    }

    //删除收藏夹
    public boolean removeFavorite(Favorite favorite) {
        String sql = "delete from favorite where favorite_id=?";
        // TODO 从数据库中删除
        return true;
    }

    //  通过用户id获取收藏夹列表
    public List<Favorite> getFavoriteByUserId(Integer userId) {
        String sql = "select favorite_id as favoriteId,user_id as userId,favorite_name as favoriteName,describe,file_path as filePath,create_time as createTime from favorite where user_id=?";
        return DBUtils.getList(Favorite.class, sql, userId);
    }

    //  查询同一用户某一收藏夹名字的数量
    public Integer selectFavoriteNameCount(Integer userId, String favoriteName) {
        String sql = "select count(*) from favorite where user_id=? and favorite_name=?";
        return DBUtils.getCount(sql, userId, favoriteName);
    }
}
