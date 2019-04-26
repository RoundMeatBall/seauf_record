function selectPage(pageName) {
    if (pageName == "1") {
        $(".dashboard2").css("display", "none");
        $(".dashboard1").css("display", "block");
    } else {
        $(".dashboard1").css("display", "none");
        $(".dashboard2").css("display", "block");
    }
}