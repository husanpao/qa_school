let colls = [];
$(".questionType").each(function (e) {
    let item = $(this);
    let title = item.find(".subject_describe").text();
    let options = [];
    item.find(".subject_node label").each(function () {
        options.push($(this).text());
    });

    let answer = item.find(".subject_add-info-content img").attr("src");
    let json = {};
    json.title = title;
    json.options = options;
    json.answer = answer;
    colls.push(json);
})
console.log(JSON.stringify(colls))

$.ajax(
    {
        url: 'http://127.0.0.1:8080/auto',
        'data': JSON.stringify(colls),
        'type': 'POST',
        'processData': false,
        'contentType': 'application/json',
        success: function (msg) {
            console.log(msg);
        }
    }
);

// $(".subject_node:eq(0) .nodeLab").text()
