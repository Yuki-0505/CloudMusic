package com.swl.dao;

import com.swl.bean.Music;
import com.swl.utils.DBUtils;

import java.util.List;

public class MusicDao {
    //  添加音乐
    public boolean appendMusic(Music music) {
        String sql = "insert into music(favorite_id,music_name,writer_name,kind,price,plays,file_path,create_time) values(?,?,?,?,?,?,?,?)";
        return DBUtils.save(sql, music.getFavoriteId(), music.getMusicName(), music.getWriterName(), music.getKind(), music.getPrice(), music.getPlays(), music.getFilePath(), music.getCreateTime());
//        return DBUtils.save(sql, 6, music.getMusicName(), music.getWriterName(), music.getKind(), music.getPrice(), music.getPlays(), music.getFilePath(), music.getCreateTime());
    }

    //删除音乐
    public boolean removeMusic(Music music) {
        String sql = "delete from music where music_id=?";
        // TODO 从数据库中删除
        return true;
    }

    //  通过userId musicId获取音乐
    public Music getMusicByUserIdAndMusicId(Integer userId, Integer musicId) {
        String sql = "select music_id as musicId,favorite_id as favoriteId,music_name as musicName,writer_name as writerName,kind,price,plays,file_path as filePath,create_time as createTime from music where user_id=? and music_id=?";
        return DBUtils.getSingleBean(Music.class, sql, userId, musicId);
    }

    //  通过userId favoriteId获取音乐列表
    public List<Music> getMusicByUserIdAndFavoriteId(Integer userId, Integer favoriteId) {
        String sql = "select music_id as musicId,favorite_id as favoriteId,music_name as musicName,writer_name as writerName,kind,price,plays,file_path as filePath,create_time as createTime from music where user_id=? and favorite_id=?";
        return DBUtils.getList(Music.class, sql, userId, favoriteId);
    }

    //  查询同一用户某一音乐名字的数量
    public Integer selectMusicNameCount(Integer userId, String musicName) {
        String sql = "select count(*) from music where userId=? and musicName=?";
        return DBUtils.getCount(sql, userId, musicName);
    }
}
