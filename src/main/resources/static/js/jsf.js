$(function() {
    window.setInterval(function() {
        $.ajax({
            url : "/mag/mag/1"
        }).document.write('<tbody>\n' +
            '    <tr th:each="contr: ${contrs}">\n' +
            '        <th scope="row"ю. th:text="${contr.ID} + \'   \'"></th>\n' +
            '        <td th:text="${contr.NAME} + \'   \'"></td>\n' +
            '        <td th:text="${contr.TMP1} + \'   \'"></td>\n' +
            '        <td th:text="${contr.TMP2} + \'   \'"></td>\n' +
            '        <td th:text="${contr.TMP3} + \'   \'"></td>\n' +
            '        <td th:text="${contr.TMP4} + \'   \'"></td>\n' +
            '        <td th:text="${contr.TMP5} + \'   \'"></td>\n' +
            '        <td th:text="${contr.BAR1} + \'   \'"></td>\n' +
            '        <td th:text="${contr.BAR2} + \'   \'"></td>\n' +
            '        <td th:text="${contr.BAR3} + \'   \'"></td>\n' +
            '        <td th:text="${contr.WAT1} + \'   \'"></td>\n' +
            '        <td th:text="${contr.WAT2} + \'   \'"></td>\n' +
            '        <td th:text="${contr.WAT3} + \'   \'"></td>\n' +
            '        <td th:text="${contr.BOOL1} + \'   \'"></td></br>\n' +
            '    </tr>\n' +
            '</tbody>');
    }, 3000);
});