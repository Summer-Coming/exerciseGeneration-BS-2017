# exerciseGeneration-BS-2017
带UI的小初高数学学习软件
用户：
小学、初中和高中学生。
功能：
1、用户注册功能。用户提供手机号码，点击注册将收到一个注册码，用户可使用该注册码完成注册；
2、用户完成注册后，界面提示设置密码，用户输入两次密码匹配后设置密码成功。密码6-10位，必须含大小写字母和数字；
3、密码设置成功后，跳转到选择界面，界面显示小学、初中和高中三个选项，用户点击其中之一后，提示用户输入需要生成的题目数量；
4、用户输入题目数量后，生成一张试卷（同一张卷子不能有相同题目），界面显示第一题的题干和四个选项，用户选择四个选项中的一个后提交，界面显示第二题，...，直至最后一题；
5、最后一题提交后，界面显示分数，分数根据答对的百分比计算；
6、用户在分数界面可选择退出或继续做题；
7、小初高数学题目要求见个人项目。
----------------------------------------------------------------------------------------------------------------------------------------
小初高题目要求：
个人项目：中小学数学卷子自动生成程序
用户：
小学、初中和高中数学老师。
功能：
1、命令行输入用户名和密码，两者之间用空格隔开（程序预设小学、初中和高中各三个账号，具体见附表），如果用户名和密码都正确，将根据账户类型显示“当前选择为XX出题”，XX为小学、初中和高中三个选项中的一个。否则提示“请输入正确的用户名、密码”，重新输入用户名、密码；
2、登录后，系统提示“准备生成XX数学题目，请输入生成题目数量：”，XX为小学、初中和高中三个选项中的一个，用户输入所需出的卷子的题目数量，系统默认将根据账号类型进行出题。每道题目的操作数在1-5个之间，操作数取值范围为1-100；
3、题目数量的有效输入范围是“10-30”（含10,30），程序根据输入的题目数量生成符合小学、初中和高中难度的题目的卷子（具体要求见附表）。同一个老师的卷子中的题目不能与以前的已生成的卷子中的题目重复（以指定文件夹下存在的文件为准，见5）；
4、在登录状态下，如果用户需要切换类型选项，命令行输入“切换为XX”，XX为小学、初中和高中三个选项中的一个，输入项不符合要求时，程序控制台提示“请输入小学、初中和高中三个选项中的一个”；输入正确后，显示“”系统提示“准备生成XX数学题目，请输入生成题目数量”，用户输入所需出的卷子的题目数量，系统新设置的类型进行出题；
5、生成的题目将以“年-月-日-时-分-秒.txt”的形式保存，每个账号一个文件夹。每道题目有题号，每题之间空一行；
6、个人项目9月25日早上8点以前提交至各自负责的助教处。提交方式：工程文件打包，压缩包名为“几班+姓名.rar”。

附表-1：账户、密码
账户类型	账户	密码	备注
小学	张三1	123	
	张三2	123	
	张三3	123	
初中	李四1	123	
	李四2	123	
	李四3	123	
高中	王五1	123	
	王五2	123	
	王五3	123	
附表-2：小学、初中、高中题目难度要求
	小学	初中	高中	
难度要求	+,-,*./	平方，开根号	sin,cos,tan	
备注	只能有+,-,*./和()	题目中至少有一个平方或开根号的运算符	题目中至少有一个sin,cos或tan的运算符	
----------------------------------------------------------------------------------------------------------------------------------------
					   说明文档
 
生成题目小程序类包具体分布见下：
 
包assignment中的Var类：声明保存全局变量。几个界面之间传数据（如输入生成的题目总数时，要把这个数据传到下一个生成具体题目的界面），最开始不知道怎么传数据比较好，最后采用了全局变量的方法。
包gui_designer：这个包下面的几个类分别是运行过程中我们操纵的6个界面。
Login：登录界面（如果账号之前注册过，可以直接输入手机号和密码进行登录，无需再注册）
ShortMessage_register：短信注册界面（如果需要短信注册，则输入手机号码，获取验证码，输入验证码，跳转到下一界面）
Set_password：设置密码界面。短信获取验证码并且输入正确后，需要为你的账号设置密码，两次确认密码输入一致（如果不一致会弹出界面提示您重新输入），直接登录~~~~
Choose：选择界面。选择需要生成题目的类型，小学、初中or高中。遵从老师发的文档要求，把出题数目也做在了这个界面，输入出题数目后，点击“生成题目”按钮，跳转到生成题目界面！
Exercise：出的题目展示界面。根据题目选择正确答案后，点击“提交”，会进行下一题。如果选择答案正确，界面会弹出答案正确的提示，反之，如果答案错误，界面也会弹出答案错误的提示。哈哈，这个功能便于助教判断本人的出题给出的答案是否正确，特地加的一个额外小功能。
Last：最后总结界面：总结总共做了多少题，做对了多少题，按照百分制最后总共得了多少分。然后可以做出选择，是继续做题还是退出程序。如果选择继续做题，则会跳转到Choose界面，继续选择出题类型和数目，继续做题！如果选择退出，则退出程序，停止运行！

最后，要特别注意以下几点：
1、	为了显示出根号和平方字符，本程序采用的是UTF-8编码。
 
2、	本程序最开始要从Login这个类先开始运行。
原因有二：
一、	按照逻辑次序，一般都是先运行登录界面。
二、	Login是主类。gui_designer这个包里面的类全部都有主函数，因为要运行界面程序。其他包里面的类是没有主函数的，仅用于被gui_designer包里的类调用。
3、	本程序高中题目中的题目中的sin、cos以及tan里面的数值代表的是角度而非弧度。 
4、	工程文件里面的user.txt文件里面放的是已经注册过的手机号和密码。每次登录，都要先查看该账户是否已注册过，若是，直接登录，否，不能登录。先注册，会自动把注册的手机号和密码添加到这个txt文件中。可查看~~~
 
5、	侧边的运行框里面的输出的内容：是把高中题目和初中题目中的特殊符号算出来之后转化成普通算式的结果，便于助教进行验证答案的正确与否。
 
6、	以上内容有可能不能涵盖全部注意事项。如果助教运行本程序过程中有任何疑问，可以随时联系本人，本人可以对遇到的问题进行解答。那啥，毕竟环境不同，万一出啥幺蛾子也不能保证~~~~
