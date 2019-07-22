<#import "common.ftl" as c>

<@c.page>
<div>

    <form method="post" action="add">
        <input class="form-control mr-sm-2" type="text" name="name" placeholder="Название"/>
        <input class="form-control mr-sm-2" type="number" name="need" placeholder="Необходимость"/>
        <input class="form-control mr-sm-2" type="number" name="number" placeholder="Количество"/>
        <button type="submit" class="btn btn-success">Добавить</button>
    </form>

</div>
</@c.page>



<#macro add path>
    <div>
        <form method="get" action="${path}">
            <button type="submit" class="btn btn-success">Добавить</button>
        </form>
    </div>
</#macro>