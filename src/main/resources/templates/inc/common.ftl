<#--分页-->
<#macro paging pageData>

    <div style="text-align: center">
        <div id="laypage-main">

        </div>
        <script>
            layui.use('laypage', function () {
                var laypage = layui.laypage;

                //执行一个laypage实例
                laypage.render({
                    elem: 'laypage-main' //注意，这里的 test1 是 ID，不用加 # 号
                    , count: ${pageData.total} //数据总数，从服务端得到
                    , curr: ${pageData.current} //当前页
                    , limit: ${pageData.size}
                    , jump: function (obj, first) {
                        //obj包含了当前分页的所有参数，比如：
                        console.log(obj.curr); //得到当前页，以便向服务端请求对应页的数据。
                        console.log(obj.limit); //得到每页显示的条数

                        //首次不执行
                        if (!first) {
                            //do something
                            location.href = "?pn=" + obj.curr;
                        }
                    }
                });
            });
        </script>

    </div>

</#macro>

<#macro plisting post>

    <li>
        <a href="/user/${post.authorId}" class="fly-avatar">
            <img src="${post.authorAvatar}" alt="${post.authorName}">
        </a>
        <h2>
            <a class="layui-badge">${post.categoryName}</a>
            <a href="/post/${post.id}">${post.title}</a>
        </h2>
        <div class="fly-list-info">
            <a href="/user/${post.authorId}" link>
                <cite>${post.authorName}</cite>
                <#--                不使用-->
                <i class="layui-badge fly-badge-vip">VIP3</i>
                <!--
                <i class="iconfont icon-renzheng" title="认证信息：XXX"></i>
                <i class="layui-badge fly-badge-vip">VIP3</i>
                -->
            </a>
            <#--可能写错了-->
            <span>${timeAgo(post.created)}</span>

            <#--                            <span class="fly-list-kiss layui-hide-xs" title="悬赏飞吻"><i class="iconfont icon-kiss"></i> 60</span>-->
            <!--<span class="layui-badge fly-badge-accept layui-hide-xs">已结</span>-->
            <span class="fly-list-nums">
                <i class="iconfont icon-pinglun1" title="回答"></i> ${post.commentCount}
              </span>
        </div>
        <div class="fly-list-badge">
            <#if post.level gt 0><span class="layui-badge layui-bg-black">置顶</span></#if>
            <#if post.recommend><span class="layui-badge layui-bg-red">精帖</span></#if>
        </div>
    </li>
</#macro>