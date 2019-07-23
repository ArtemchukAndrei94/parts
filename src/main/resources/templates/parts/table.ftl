

<table class="table table-striped" border="1">
    <thead class="thead-dark">
    <tr>
        <th scope="col">Наименование</th>
        <th scope="col">Необходимость</th>
        <th scope="col">Количество</th>
        <th scope="col"></th>
        <th scope="col"></th>
    </tr>
    </thead>
    <tbody>
    <#list page.content as part>
        <tr>
            <td> ${part.name}</td>
            <td> ${part.need}</td>
            <td> ${part.number}</td>
            <td>
                <form action="/edit${part.id}">
                    <button class="btn btn-primary" type="submit">Редактировать</button>
                </form>
            </td>
            <td>
                <form action="/delete${part.id}">
                    <button class="btn btn-danger" type="submit">Удалить</button>
                </form>
            </td>
        </tr>

    </#list>
    </tbody>
</table>