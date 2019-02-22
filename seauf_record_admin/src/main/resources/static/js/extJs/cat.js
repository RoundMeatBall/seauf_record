Ext.define('Cat', {
    requires: ["Animal"],

    extend:'Animal',
    owner:"lynn",

    constructor: function (o) {
        //复制o中的所有属性到自身
        Ext.apply(this, o);
    }
});