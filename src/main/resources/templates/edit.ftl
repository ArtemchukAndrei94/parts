<#import "parts/common.ftl" as c>

<@c.page>
<div>
    <form method="post" action="/edit${part.id}">

        <div class="form-group row">
            <label for="name" class="col-sm-2 col-form-label">Название</label>
            <div class="col-sm-10">
                <input class="form-control" type="text" name="name" value="${part.name}">
            </div>
        </div>
        <fieldset class="form-group">
            <div class="row">
                <legend class="col-form-label col-sm-2 pt-0">Необходимость</legend>
                <div class="col-sm-10">
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="need" value="1" checked>
                        <label class="form-check-label" for="need">
                            Да
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="need"  value="0">
                        <label class="form-check-label" for="need">
                            Нет
                        </label>
                    </div>
                </div>
            </div>
        </fieldset>
        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Количество</label>
            <div class="col-sm-10">
                <input class="form-control" type="number" name="number" value="${part.number}">
            </div>
        </div>
        <div class="form-group row">
            <div class="col-sm-10">
                <button type="submit" class="btn btn-success">Редактировать</button>
            </div>
        </div>
    </form>

</div>
</@c.page>






