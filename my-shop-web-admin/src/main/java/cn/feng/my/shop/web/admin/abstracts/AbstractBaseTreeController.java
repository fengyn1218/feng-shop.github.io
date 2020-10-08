package cn.feng.my.shop.web.admin.abstracts;

import cn.feng.my.shop.commons.persistence.BaseTreeEntity;
import cn.feng.my.shop.commons.persistence.BaseTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @description:
 * @author:冯雨南
 * @createDate: 2020/5/5
 * @version:1.0.0
 */
public abstract class AbstractBaseTreeController<T extends BaseTreeEntity, S extends BaseTreeService<T>> {

    @Autowired
    protected S service;

    //跳转列表页
    public abstract String list(Model model);

    //跳转表单页
    public abstract String form(T entity);

    //保存信息
    public abstract String save(T entity, Model model, RedirectAttributes redirectAttributes);

    //树形结构
    public abstract List<T> treeData(Long id);

    //排序
    /**
     * @description: 排序
     * @param: sourceList 排序前集合
     * @param: targetList 排序后集合
     * @param: parentId 父类目ID
     * @return: void
     * @author:冯雨南
     * @date: 2020/4/16 14:29
     * @version:1.0.0
     **/
    protected void sortList(List<T> sourceList, List<T> targetList, Long parentId) {
        for (T sourceEntity : sourceList) {
            if (sourceEntity.getParent().getId().equals(parentId)) {
                targetList.add(sourceEntity);

                //判断有没有子节点，如果有继续追加
                if (sourceEntity.getIsParent()) {
                    for (T currentEntity : sourceList) {
                        if (currentEntity.getParent().getId().equals(sourceEntity.getId())) {
                            sortList(sourceList, targetList, sourceEntity.getId());
                            break;
                        }
                    }
                }
            }
        }
    }
}
