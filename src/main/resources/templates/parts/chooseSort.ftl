<#macro select>
<form method="post" action="/select">
    <div class="form-row align-items-center">
        <div class="col-auto my-1">
            <select class="form-control mr-sm-2" name="need">
                <option value="2" selected>Все комплектующие</option>
                <option value="1">Необходимые</option>
                <option value="0">Опциональные</option>
            </select>
            <button class="btn btn-info" type="submit">Сортировать</button>
        </div>
    </div>
</form>
</#macro>