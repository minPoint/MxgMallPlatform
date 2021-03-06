package org.minpoint.muxige.core.utils;

import com.github.pagehelper.PageHelper;
import org.minpoint.muxige.core.pojo.BaseModel;

/*
 * @ClassName PagingUtils
 * @Description
 * @author BabyBlackSkin
 * @version 1.00
 * @since 2021/12/18 11:42
 */
public class PagingUtils {

    /**
     * @Author BabyBlackSkin
     * @Description  默认分页，每次查询1000条
     * @Date 11:44 2021/12/18
     * @Param []
     * @return void
     **/
    public static void defaultPaging(){
        PageHelper.startPage(1, 1000);
    }

    /**
     * @Author BabyBlackSkin
     * @Description   自动分页，按照入参分页，如果入参没有分页则默认分页
     * @Date 11:44 2021/12/18
     * @Param
     * @return
     **/
    public static void autoPaging(BaseModel model){
        if(model.isPaging()){
            PageHelper.startPage(model.getPageNum(), model.getPageSize());
        }else{
            defaultPaging();
        }
    }
}
