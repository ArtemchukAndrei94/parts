<#import "parts/common.ftl" as c>
<#import "add.ftl" as a>
<#import "parts/pager.ftl" as p>
<#import "parts/chooseSort.ftl" as choose>

<@c.page>

    <@choose.select/>
    <#include "parts/table.ftl">
    <@p.pager url page/>

    <div>
        <span>Количество деталей : ${countAll}</span>
    </div>

    <div>
        <span>Можно собрать : ${countMin}</span>
    </div>
    <@a.add "/add"/>

</@c.page>