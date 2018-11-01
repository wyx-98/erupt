package com.erupt.test;

import com.erupt.annotation.constant.RgbColor;
import com.erupt.annotation.constant.UiColor;
import com.erupt.annotation.Erupt;
import com.erupt.annotation.EruptField;
import com.erupt.annotation.sub_erupt.Card;
import com.erupt.annotation.sub_erupt.Power;
import com.erupt.annotation.sub_erupt.RowOperation;
import com.erupt.annotation.sub_field.Edit;
import com.erupt.annotation.sub_field.EditType;
import com.erupt.annotation.sub_field.Search;
import com.erupt.annotation.sub_field.View;
import com.erupt.annotation.sub_field.sub_edit.*;
import com.erupt.model.BaseModel;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * Created by liyuepeng on 9/28/18.
 */
@Erupt(
        name = "测试",
        power = @Power,
        rowOperation = @RowOperation(
                icon = "fa fa-terminal",
                title = "执行",
                operationHandler = OperationHandlerImpl.class,
                edits = {
                        @Edit(
                                title = "姓名",
                                notNull = true
                        ),
                        @Edit(
                                title = "身份证号",
                                notNull = true
                        )
                }
        ),
        cards = {
                @Card(icon = "fa fa-table", value = "100", desc = "第一个卡片", color = RgbColor.green),
                @Card(icon = "fa fa-table", value = "200", desc = "第二个卡片", color = RgbColor.red),
                @Card(icon = "fa fa-table", value = "300", desc = "第三个卡片", color = RgbColor.blue),
                @Card(icon = "fa fa-table", value = "400", desc = "第四个卡片", color = RgbColor.yellow)
        }
)
@Entity
@Table(name = "ERUPT_TEST")
public class Mmo extends BaseModel {


    @Column(name = "NAME")
    @EruptField(
            views = {
                    @View(title = "名称")
            },
            edit = @Edit(
                    title = "名称",
                    notNull = true,
                    inputType = @InputType(color = UiColor.success),
                    search = @Search(isSearch = true)
            )
    )
    private String input;


    @EruptField(
            views = {
                    @View(title = "number")
            },
            edit = @Edit(
                    title = "数字",
                    notNull = true,
                    search = @Search(isSearch = true)
            )
    )
    private Integer age;

    @Column(name = "TEXT")
    @EruptField(
            views = @View(title = "选择"),
            edit = @Edit(
                    title = "选择",
                    notNull = true,
                    type = EditType.CHOICE,
                    choiceType = {
                            @ChoiceType(
                                    vl = {
                                            @VL(value = 123, label = "张三"),
                                            @VL(value = 234, label = "李四"),
                                            @VL(value = 456, label = "王五")
                                    },
                                    type = ChoiceEnum.SELECT_SINGLE
                            )
                    },
                    search = @Search(isSearch = true)
            )

    )
    private String choice;


    @EruptField(
            views = @View(title = "选择"),
            edit = @Edit(
                    title = "选择",
                    notNull = true,
                    type = EditType.CHOICE,
                    choiceType = {
                            @ChoiceType(
                                    vl = {
                                            @VL(value = 123, label = "张三"),
                                            @VL(value = 234, label = "李四"),
                                            @VL(value = 456, label = "王五"),
                                            @VL(value = 2341, label = "李四"),
                                            @VL(value = 2343, label = "李四"),
                                            @VL(value = 2344, label = "李四"),
                                    },
                                    type = ChoiceEnum.SINGLE
                            )
                    },
                    search = @Search(isSearch = true)
            )
    )
    private String single;

    @EruptField(
            views = @View(title = "布尔"),
            edit = @Edit(
                    notNull = true,
                    title = "布尔",
                    type = EditType.BOOLEAN,
                    boolType = @BoolType(trueText = "是的", falseText = "不行")
            )
    )
    private Boolean bool;

    @EruptField(
            edit = @Edit(
                    notNull = true,
                    title = "时间",
                    type = EditType.DATE,
                    dateType = @DateType,
                    group = "分组2"
            )
    )
    private Date date;

    @EruptField(
            edit = @Edit(
                    title = "图片",
                    type = EditType.IMAGE
            )
    )
    private String image;


    @EruptField(
            views = {
                    @View(title = "input", column = "input"),
                    @View(title = "年龄", column = "age"),
            },
            edit = @Edit(
                    title = "tab1",
                    type = EditType.TAB
            )
    )
    @OneToMany(fetch=FetchType.EAGER)
    private Set<SubMmo> sub;

//    @EruptField(
//            edit = @Edit(
//                    title = "tab2",
//                    type = EditType.TAB,
//                    tabType = @TabType(icon = "fa fa-table")
//            )
//    )
//    private String tab2;


    @EruptField(
            views = {
                    @View(title = "标签")
            },
            edit = @Edit(
                    group = "分组2",
                    title = "名称",
                    notNull = true,
                    inputType = @InputType(type = InputEnum.TEXTAREA, color = UiColor.success)
            )
    )
    private String gender;

}
