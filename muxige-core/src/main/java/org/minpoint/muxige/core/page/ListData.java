package org.minpoint.muxige.core.page;


import com.github.pagehelper.Page;
import lombok.Getter;
import lombok.Setter;
import org.minpoint.muxige.utils.JsonUtils;

import java.util.List;

/*
 * @ClassName ListData
 * @Description
 * @author BabyBlackSkin
 * @version 1.00
 * @since 2021/12/8 21:38
 */
@Getter
@Setter
public class ListData<T>{

    private T content;

    private PageInfo pageInfo;

    private static  <T> ListData<T> setPage(List list){
        ListData<T> listData = new ListData<>();
        if(list instanceof Page){
            Page<T> page = (Page<T>) list;
            listData.setPageInfo(new PageInfo(page.getTotal(), page.getPageSize(), page.getPageNum(), page.getPages()));
        }
        return listData;
    }

    public static <T> ListData<T> create(List list, Class<T> tClass){
        ListData listData = ListData.setPage(list);
        listData.setContent(JsonUtils.listToList(list, tClass));
        return listData;
    }

    public static <T> ListData<T> create(List list){
        ListData listData = ListData.setPage(list);
        listData.setContent(list);
        return listData;
    }

}
