package xyz.erupt.annotation.sub_field.sub_edit;

/**
 * Created by liyuepeng on 2019-01-13.
 */
public @interface DependSwitchAttr {
    String[] dependEdits();

    String name();

    int val();
}