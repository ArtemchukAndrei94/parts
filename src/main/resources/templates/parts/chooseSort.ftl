<#macro select>
    <div class="dropdown">
        <a class="btn btn-secondary dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            Сортировка
        </a>

        <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
            <a class="dropdown-item" href="/main">Все комплектующие</a>
            <a class="dropdown-item" href="/select${1}">Необходимые</a>
            <a class="dropdown-item" href="/select${0}">Опциональные</a>
        </div>
    </div>



</#macro>








<#--
<div class="container">
    <form method="get" action="select">
        <div class="form-row align-items-center">
            <div class="col-auto my-1">
                <div class="row">
                    <div class="col-sm">
                        <select class="form-control mr-sm-2" name="need">
                            <option>Все комплектующие</option>
                            <option value="1">Необходимые</option>
                            <option value="0">Опциональные</option>
                        </select>
                    </div>
                    <div class="col-sm">
                        <button class="btn btn-info" type="submit">Сортировать</button>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>-->
