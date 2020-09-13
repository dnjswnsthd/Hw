const btn = $("#btn");
let flag = true, numbers;

function decryptEffect(elem, time) {
    const effect = setInterval(function() {
        elem.text(Math.floor(Math.random()*numbers.length) + 1)
    }, 20);

    setTimeout(function() {
        const random = Math.floor((Math.random()*numbers.length) + 1);
        clearInterval(effect),
        elem.addClass("done"),
        elem.text(numbers[random]),
        numbers.splice(random, 1)
    },  time * 1000 + 1000)
}

function lottery() {
    $(".ball").each(function() {
        $(this).removeClass("done"),
        decryptEffect($(this), $(this).prevAll().length)
    })
}

btn.click(function() {
    if(flag) {
      numbers = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45],
      flag = false,
      btn.addClass("hide"),
      lottery(),
      setTimeout(function() {
          flag = true,
          btn.removeClass("hide")
      }, 8500)
    }
})
