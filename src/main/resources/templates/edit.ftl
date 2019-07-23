<#import "parts/common.ftl" as c>

<@c.page>
<div>

    <form method="post" action="/edit${part.id}">
        <input class="form-control mr-sm-2" type="text" name="name" value="${part.name}"/>
        <input class="form-control mr-sm-2" type="number" name="need" value="${part.need}"/>
        <input class="form-control mr-sm-2" type="number" name="number" value="${part.number}"/>
        <button type="submit" class="btn btn-success">Редактировать</button>
    </form>

</div>
</@c.page>
