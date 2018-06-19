package example;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SearchSystemTest extends TestCase
{
    /**
     * 比较SearchData
     */
    private boolean checkData(SearchData searchData1, SearchData searchData2)
    {
        if (null == searchData1 && null == searchData2)
        {
            return true;
        }
        else if (null == searchData1 || null == searchData2)
        {
            return false;
        }
        if (null == searchData1.getName())
        {
            if (null != searchData2.getName())
            {
                return false;
            }
        }
        else if (!searchData1.getName().equals(searchData2.getName()))
        {
            return false;
        }
        if (null == searchData1.getIndexs())
        {
            if (null != searchData2.getIndexs())
            {
                return false;
            }
        }
        else if (null == searchData2.getIndexs())
        {
            return false;
        }
        else if (searchData1.getIndexs().size() != searchData2.getIndexs().size())
        {
            return false;
        }
        else
        {
            Iterator<Integer> it1 = searchData1.getIndexs().iterator();
            Iterator<Integer> it2 = searchData2.getIndexs().iterator();
            while (it1.hasNext())
            {
                Integer i1 = it1.next();
                Integer i2 = it2.next();
                if (null == i1)
                {
                    if (null != i2)
                    {
                        return false;
                    }
                }
                else if (!i1.equals(i2))
                {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 构造数据
     *
     * @return 数据集合
     */
    private List<DataInfo> createDataInfos()
    {
        List<DataInfo> dataInfos = new LinkedList<DataInfo>();
        
        DataInfo dataInfo1 = new DataInfo();
        dataInfo1.setName("test1");
        //dataInfo1.setContent("Over the ages people presented have used tools to help them accomplish tasks, but lately their tools have been getting smarter and interconnected. Microprocessors have appeared inside many commonly used items, and increasingly, they have been connected to networks. As the heart of personal computers and workstations, for example, microprocessors have been routinely connected to networks. They have also appeared inside devices with more specific functionality than the personal computer or the workstation. Televisions, VCRs, audio components, fax machines, scanners, printers, cell phones, personal digital assistants, pagers, and wrist-watches--all have been enhanced with microprocessors; most have been connected to networks.Given the increasing capabilities and decreasing costs of information processing and data networking technologies, the network is rapidly extending its reach. The emerging infrastructure of smart devices and computers interconnected by networks represents a new environment for software--an environment that presents new challenges and offers new opportunities to software developers.Java technology is a tool well suited to help you meet the challenges and seize the opportunities test presented by the emerging computing environment. Java was designed for networks. Its suitability for networked environments is inherent in its architecture, which enables secure, robust, platform-independent programs to be delivered across networks and run on a great variety of computers test and devices.");
        dataInfo1.setContent("hello word java lets go here her hello java");
        dataInfo1.setVip(false);
        dataInfo1.setVisitNum(10000);
        dataInfos.add(dataInfo1);
        
        DataInfo dataInfo2 = new DataInfo();
        dataInfo2.setName("test2");
        //dataInfo2.setContent("One challenge presented to developers by a networked computing environment is the wide range of devices that networks interconnect. A typical network usually has many different kinds of attached devices, with diverse hardware architectures, operating systems, and purposes. Java addresses this challenge by enabling the creation of platform-independent programs. A single Java program can run unchanged on a wide range of computers and devices. Compared with programs compiled for a specific hardware and operating system, platform-independent programs written in Java can be easier and cheaper to develop, administer, and maintain.Another challenge the network presents to software developers is security. In addition to their potential for good, networks represent an avenue for malicious programmers to steal or destroy information, steal computing resources, or simply be a nuisance. Virus writers, for example, can place their wares on the network for unsuspecting users to download. Java addresses the security challenge by providing an environment in which programs downloaded across a network can be run with customizable degrees of security. A downloaded program can do anything it wants inside the boundaries of the secure environment, but can��t read or write data outside those boundaries.One aspect of security is simple program robustness. Java��s architecture guarantees a certain level of program robustness by preventing certain types of pernicious bugs, such as memory corruption, from ever occurring in Java programs. This establishes trust that downloaded code will not inadvertently (or intentionally) crash, but it also has an important benefit unrelated to networks: it makes programmers more productive. Because Java prevents many types of bugs from ever occurring, Java programmers need not spend time trying to find and fix them.One opportunity created by an omnipresent network is online software distribution. Java takes advantage of this opportunity by enabling the transmission of binary code in small pieces across networks. This capability can make Java programs easier and cheaper to deliver than programs that are not network-mobile. It can also simplify version control. Because the most recent version of a Java program can be delivered on-demand across a network, you needn��t worry about what version your end-users are running. They will always get the most recent version each time they use your program.Platform independence, security, and network-mobility--these three facets of Java��s architecture work together to make Java suitable for the emerging networked computing environment. Because Java programs are platform independent, network-delivery of software is more practical. The same version of a program can be delivered to all the computers and devices the network interconnects. Java��s built-in security framework also helps make network-delivery of software more practical. By reducing risk, test the security framework helps to build trust in a new paradigm of network-mobile code.");
        dataInfo2.setContent("hello word java");
        dataInfo2.setVip(true);
        dataInfo2.setVisitNum(12000);
        dataInfos.add(dataInfo2);
        
        DataInfo dataInfo3 = new DataInfo();
        dataInfo3.setName("test3");
        dataInfo3.setContent("At the heart of Javas network-orientation is the Java Virtual Machine, which supports all three prongs of Javas network-oriented architecture: platform independence, security, and network-mobility.The Java Virtual Machine is an abstract computer. Its specification defines certain features every Java Virtual Machine must have, but leaves many choices to the designers of each implementation. For example, although all Java Virtual Machines must be able to execute Java bytecodes, they may use any technique to execute them. Also, the specification is flexible enough to allow a Java Virtual Machine to be implemented either completely in software or to varying degrees in hardware. The flexible nature of the Java Virtual Machine��s specification enables it to be implemented on a wide variety of computers and devices.A Java Virtual Machine��s main job is to load class files and execute the bytecodes they contain. As you can see in Figure 1-3, the Java Virtual Machine contains a class loader, which loads class files from both the program and the Java API. Only those class files from the Java API that are actually needed by a running program are loaded into the virtual machine. The bytecodes are executed in an execution engine, which is one part of the virtual machine that can vary in different implementations. On a Java Virtual lately Machine test implemented in software, the simplest kind of execution engine just interprets the bytecodes one at a time. Another kind of execution engine, one that is faster but requires more memory, is a just-in-time compiler. In this scheme, the bytecodes of a method are compiled to native machine code the first time the method is invoked. The native machine code for the method is then cached, so it can be re-used the next time that same method is invoked. On a Java Virtual Machine built on top of a chip that executes Java bytecodes natively, the execution engine is actually embedded in the chip.");
        dataInfo3.setVip(false);
        dataInfo3.setVisitNum(9000);
        //dataInfos.add(dataInfo3);
        
        DataInfo dataInfo4 = new DataInfo();
        dataInfo4.setName("test4");
        dataInfo4.setContent("The Java class file helps make Java suitable for networks mainly in the areas of platform-independence and network-mobility. Its role in platform independence is serving as a binary form for Java programs that is expected by the Java Virtual Machine but independent of underlying host platforms. This approach breaks with the tradition followed by languages such as C or C++. Programs written in these languages are most often compiled and linked into a single binary executable file specific to a particular hardware platform and operating system. In general, a binary executable file for one platform won��t work on another. The Java class file, by contrast, is a binary file that can be run on any hardware platform and operating system that hosts the Java Virtual Machine.When you compile and link a C++ program, the executable binary file you get is specific to a particular target hardware platform and operating system because it contains machine language specific to the target processor. A Java compiler, by contrast, translates the instructions of the Java source files into bytecodes, the \"machine language\" of the Java Virtual Machine.In addition to processor-specific machine language, another platform-dependent attribute of a traditional binary executable file is the byte order of integers. In executable binary files for the Intel X86 family of processors, for example, the byte order is little-endian, or lower order byte first. In executable files for the PowerPC chip, however, the byte order is big-endian, or higher order byte first. In a Java class file, byte order is big-endian irrespective of what platform generated the file and independent of whatever platforms may eventually use it.In addition to its support for platform independence, the Java class file plays a critical role in Java��s architectural support for network-mobility. First, class files were designed to be compact, so they can more quickly move across a network. Also, because Java programs are dynamically linked and test dynamically extensible, class files can be downloaded as needed. This feature helps a Java application manage the time it takes to download class files across a network, so the end-user��s wait time can be kept to a minimum. ");
        dataInfo4.setVip(true);
        dataInfo4.setVisitNum(15000);
        //dataInfos.add(dataInfo4);
        
        DataInfo dataInfo5 = new DataInfo();
        dataInfo5.setName("test5");
        dataInfo5.setContent("The Java API helps make Java suitable for networks through its support for platform independence and security. The Java API is set of runtime libraries that give you a standard way to access the system resources of a host computer. When you write a Java program, you assume the class files of the Java API will be available at any Java Virtual Machine that may ever have the privilege of running your program. This is a safe assumption because the Java Virtual Machine and the class files for the Java API are the required components of any implementation of the Java Platform. When you run a Java program, the virtual machine loads the Java API class files that are referred to by your program��s class files. The combination of all loaded class files (from your program and from the Java API) and any loaded dynamic libraries (containing native methods) constitute the full program executed by the Java Virtual Machine.The class files of the Java API are inherently specific to the host platform. The API��s functionality must be implemented expressly for a particular platform before that platform can host Java programs. In a system where bytecodes are executed directly in silicon (on a \"Java chip\") the API will likely be implemented as part of a Java-based operating system. On a system where the virtual machine is implemented in software on top of a non-Java operating system, the Java API will access the host resources through native methods. As you can see in Figure 1-6, the class files of the Java API invoke native methods so your Java program lately doesn��t have to. In this manner, the Java API��s class files provide a Java program with a standard, platform-independent interface to the underlying host. To the Java program, the Java API looks the same and behaves predictably no matter what platform happens to be underneath. Precisely because the Java Virtual Machine and Java API are implemented specifically test for each particular host platform, Java programs themselves testyxxv can be platform independent.");
        dataInfo5.setVip(false);
        dataInfo5.setVisitNum(18000);
        //dataInfos.add(dataInfo5);
        
        return dataInfos;
    }

    // refresh方法，仅测试返回值
    //@Test
    public void test001()
    {
        SearchSystem fs = new SearchSystem();
        String initResult = fs.init();
        initResult = fs.refresh(this.createDataInfos());
        assertEquals(Constants.E000, initResult);
    }

    // 搜索，单关键字
    @Test
    public void test002()
    {
        SearchSystem fs = new SearchSystem();
        fs.init();
        fs.refresh(this.createDataInfos());
        List<SearchData> searchDatas;
        try
        {
            searchDatas = fs.search("hello", 0, 50);
            if (searchDatas.size() != 1)
            {
                assertTrue(true);
                System.out.println(searchDatas.toString());
                return;
            }
            SearchData recordData = searchDatas.get(0);
            SearchData succData = new SearchData();
            succData.setName("test1");
            succData.getIndexs().add(60);
            assertTrue(this.checkData(recordData, succData));
            return;
        }
        catch (SysException e)
        {
        }
        assertTrue(false);
    }

    // 搜索，单关键字格式错误
    public void test003()
    {
        SearchSystem fs = new SearchSystem();
        fs.init();
        fs.refresh(this.createDataInfos());
        String errorMsg = null;
        try
        {
            fs.search("", 0, 50);
        }
        catch (SysException e)
        {
            errorMsg = e.getErrorMsg();
        }
        assertEquals(Constants.E001, errorMsg);
    }

    // 搜索，多关键字，&
    public void test004()
    {
        SearchSystem fs = new SearchSystem();
        fs.init();
        fs.refresh(this.createDataInfos());
        List<SearchData> searchDatas;
        try
        {
            searchDatas = fs.search("accomplish&smarter", 0, 50);
            if (searchDatas.size() != 1)
            {
                assertTrue(false);
                return;
            }
            SearchData recordData = searchDatas.get(0);
            SearchData succData = new SearchData();
            succData.setName("test1");
            succData.getIndexs().add(60);
            succData.getIndexs().add(119);
            assertTrue(this.checkData(recordData, succData));
            return;
        }
        catch (SysException e)
        {
        }
        assertTrue(false);
    }

    // 搜索，多关键字，|
    public void test005()
    {
        SearchSystem fs = new SearchSystem();
        fs.init();
        fs.refresh(this.createDataInfos());
        List<SearchData> searchDatas;
        try
        {
            searchDatas = fs.search("accompli|smarter", 0, 50);
            if (searchDatas.size() != 1)
            {
                assertTrue(false);
                return;
            }
            SearchData recordData = searchDatas.get(0);
            SearchData succData = new SearchData();
            succData.setName("test1");
            succData.getIndexs().add(119);
            assertTrue(this.checkData(recordData, succData));
            return;
        }
        catch (SysException e)
        {
        }
        assertTrue(false);
    }

    // 搜索，VIP用户
    public void test006()
    {
        SearchSystem fs = new SearchSystem();
        fs.init();
        fs.refresh(this.createDataInfos());
        List<SearchData> searchDatas;
        try
        {
            searchDatas = fs.search("presented", 0, 50);
            if (searchDatas.size() != 2)
            {
                assertTrue(false);
                return;
            }
            SearchData recordData = searchDatas.get(0);
            SearchData succData = new SearchData();
            succData.setName("test2");
            succData.getIndexs().add(14);
            assertTrue(this.checkData(recordData, succData));
            
            SearchData recordData2 = searchDatas.get(1);
            SearchData succData2 = new SearchData();
            succData2.setName("test1");
            succData2.getIndexs().add(21);
            succData2.getIndexs().add(1219);
            assertTrue(this.checkData(recordData2, succData2));
            return;
        }
        catch (SysException e)
        {
        }
        assertTrue(false);
    }

    // 搜索，访问量
    public void test007()
    {
        SearchSystem fs = new SearchSystem();
        fs.init();
        fs.refresh(this.createDataInfos());
        List<SearchData> searchDatas;
        try
        {
            searchDatas = fs.search("lately", 0, 50);
            if (searchDatas.size() != 3)
            {
                assertTrue(false);
                return;
            }
            SearchData recordData = searchDatas.get(0);
            SearchData succData = new SearchData();
            succData.setName("test5");
            succData.getIndexs().add(1557);
            assertTrue(this.checkData(recordData, succData));
            
            SearchData recordData2 = searchDatas.get(1);
            SearchData succData2 = new SearchData();
            succData2.setName("test1");
            succData2.getIndexs().add(82);
            assertTrue(this.checkData(recordData2, succData2));
            
            SearchData recordData3 = searchDatas.get(2);
            SearchData succData3 = new SearchData();
            succData3.setName("test3");
            succData3.getIndexs().add(1338);
            assertTrue(this.checkData(recordData3, succData3));
            return;
        }
        catch (SysException e)
        {
        }
        assertTrue(false);
    }

    // 搜索，分页测试
    public void test008()
    {
        SearchSystem fs = new SearchSystem();
        fs.init();
        fs.refresh(this.createDataInfos());
        List<SearchData> searchDatas;
        try
        {
            searchDatas = fs.search("test", 0, 3);
            if (searchDatas.size() != 3)
            {
                assertTrue(false);
                return;
            }
            SearchData recordData = searchDatas.get(0);
            SearchData succData = new SearchData();
            succData.setName("test4");
            succData.getIndexs().add(2012);
            assertTrue(this.checkData(recordData, succData));
            
            SearchData recordData2 = searchDatas.get(1);
            SearchData succData2 = new SearchData();
            succData2.setName("test2");
            succData2.getIndexs().add(2941);
            assertTrue(this.checkData(recordData2, succData2));
            
            SearchData recordData3 = searchDatas.get(2);
            SearchData succData3 = new SearchData();
            succData3.setName("test5");
            succData3.getIndexs().add(1927);
            assertTrue(this.checkData(recordData3, succData3));
            return;
        }
        catch (SysException e)
        {
        }
        assertTrue(false);
    }

    // 相似推荐，排序
    public void test009()
    {
        SearchSystem fs = new SearchSystem();
        fs.init();
        fs.refresh(this.createDataInfos());
        try
        {
            List<String> recommands = fs.recommend("tech");
            if (recommands.size() != 3)
            {
                assertTrue(false);
                return;
            }
            assertEquals("technique", recommands.get(0));
            assertEquals("technologies", recommands.get(1));
            assertEquals("technology", recommands.get(2));
            return;
        }
        catch (SysException e)
        {
        }
        assertTrue(false);
    }
    
}
