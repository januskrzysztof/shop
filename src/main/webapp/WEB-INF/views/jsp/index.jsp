<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
    var imgs = new Array('Fifa_2015.jpg',
            'Effective_Java.jpg',
            'Spring_In_Action.jpg', 'Animals.jpg',
            'American_Sniper.jpg');

    var imgs2 = new Array('Effective_Java.jpg',
            'Spring_In_Action.jpg', 'Animals.jpg',
            'American_Sniper.jpg',
            'Fifa_2015.jpg');
    var imgs3 = new Array('Spring_In_Action.jpg',
            'Animals.jpg',
            'American_Sniper.jpg',
            'Fifa_2015.jpg',
            'Effective_Java.jpg');
    var src1 = new Array('/product/detail/10', '/product/detail/2', '/product/detail/1', '/product/detail/6', '/product/detail/7');
    var src2 = new Array('/product/detail/2', '/product/detail/1', '/product/detail/6', '/product/detail/7', '/product/detail/10');
    var src3 = new Array('/product/detail/1', '/product/detail/6', '/product/detail/7', '/product/detail/10', '/product/detail/2');

    var pos = 0;

    function chImg() {
        var i = document.getElementById('imgField');
        var j = document.getElementById('imgField2');
        var k = document.getElementById('imgField3');

        var ii = document.getElementById('imgSource');
        var jj = document.getElementById('imgSource2');
        var kk = document.getElementById('imgSource3');
        ii.href = src1[pos];
        jj.href = src2[pos];
        kk.href = src3[pos];
        i.src = '/resources/productImages/' + imgs[pos];
        j.src = '/resources/productImages/' + imgs2[pos];
        k.src = '/resources/productImages/' + imgs3[pos];
        ++pos;

        if (pos > 4) {
            pos = 0;
        }

        window.setTimeout('chImg()', 5000);
    }
</script>


<h1 class="page-header" align="center">Welcome in Luxoft Online Store</h1>

<div class="row placeholders">
    <div style="width: 235px; float: left; margin-left: 40px; margin-top: 50px ">
        <a href="" id="imgSource"><img src="" width='150px' height='180px' id="imgField" margin-left='10px'
                                       margin-right="10px"></a>
    </div>
    <div style="width: 235px; float:left;margin-top: 40px">
        <a href="" id="imgSource2"><img src="" width='180px' height='220px' id="imgField2"></a>
    </div>
    <div style="width: 235px; float: left; margin-right: 40px; margin-top: 50px">
        <a href="" id="imgSource3"> <img src="" width='150px' height='180px' id="imgField3"></a>
    </div>
    <script>
        chImg();
    </script>
</div>