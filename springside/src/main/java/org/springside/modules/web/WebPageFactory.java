package org.springside.modules.web;

import com.google.common.base.Strings;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;

/**
 * Created by wangrui on 2015/5/26.
 *
 */
public class WebPageFactory {

    private static final int DEFAULT_PAGE = 0;
    private static final int DEFAULT_SIZE = 10;
    /**
     * 处理JqGrid 分页
     * @param request
     * @return
     */
    public static PageRequest buildJqGridPage(ServletRequest request){
        String page = request.getParameter("page");
        String rows = request.getParameter("rows");
        String sidx = request.getParameter("sidx");
        String sord = request.getParameter("sord");
        String totalrows = request.getParameter("totalrows");
        int pageNumber = Integer.valueOf(page) - 1;
        int pageSize = Integer.valueOf( rows );
        if( !Strings.isNullOrEmpty(totalrows) ){
            pageSize = Integer.valueOf( totalrows );
        }
        Sort.Order order = new Sort.Order(Sort.Direction.fromString(sord) , sidx);
        Sort sort = new Sort(order);
        PageRequest pageRequest = new PageRequest(pageNumber , pageSize , sort);
        return pageRequest;
    }

    /**
     * 通用的分页
     * @param request
     * @return
     */
    public static PageRequest buildCommonPage(ServletRequest request){
        String page = request.getParameter("page");
        String size = request.getParameter("size");
        String sidx = request.getParameter("sidx");
        String sord = request.getParameter("sord");
        //String totalrows = request.getParameter("totalrows");


        int pageNumber = DEFAULT_PAGE, pageSize = DEFAULT_SIZE;
        if ( !Strings.isNullOrEmpty(page) ){
            try{
                pageNumber = Integer.valueOf(page);
                pageNumber--;
            }catch (NumberFormatException ne){
                pageNumber = DEFAULT_PAGE;
            }
        }

        if ( !Strings.isNullOrEmpty(size) ){
            try{
                pageSize = Integer.valueOf(size);
                if( pageSize == 0) pageSize = DEFAULT_SIZE;
            }catch (NumberFormatException ne){
                pageSize = DEFAULT_SIZE;
            }
        }


        //if( !Strings.isNullOrEmpty(totalrows) ){   // 每页显示多少行记录  例如每页显示50 条记录
         //   pageSize = Integer.valueOf( totalrows );
        //}
        PageRequest pageRequest = null;
        if( StringUtils.hasText(sidx) && StringUtils.hasText(sord)){  // 排序
            Sort.Order order = new Sort.Order(Sort.Direction.fromString(sord) , sidx);
            Sort sort = new Sort(order);
            pageRequest = new PageRequest(pageNumber , pageSize , sort);
        }else{
            pageRequest = new PageRequest(pageNumber, pageSize);
        }

        return pageRequest;
    }
}
