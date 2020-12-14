import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;


public class CreateXL {
	/** Excel 文件要存放的位置，假定在F盘下*/
	public static String outputFile = "F:\\test.xls";
	public static void main(String argv[]) {

		//定义二维数组

		String xf[][]={
				{
					"序号", "学期", "课程代号", "课程名称", "学分", "成绩", "计划学期", "计划代码", "计划名称", "计划学分", "课程性质"
				},
				{
					"1", "2018-2019_2", "BG000000210", "大学计算机基础", "3", "74", "2018-2019_1", "BG000000210", "大学计算机基础", "3", "BG通识必修"
				},
				{
					"2", "2019-2020_1", "BG0000006X0", "大学英语3", "3.5", "69", "2019-2020_1", "BG0000006X0", "大学英语3", "3.5", "BG通识必修"
				}
		};

		try {
			// 创建新的Excel 工作簿
			HSSFWorkbook workbook = new HSSFWorkbook();
			// 在Excel工作簿中建一工作表，其名为缺省值
			// 如要新建一名为"效益指标"的工作表，其语句为：
			HSSFSheet sheet = workbook.createSheet("学生成绩");
			// 在索引0的位置创建行（最顶端的行）
			for(int i=0;i<xf.length;i++) {
				// 在索引0的位置创建行（最顶端的行）
				HSSFRow row = sheet.createRow((short)i);
				for (int j = 0; j < xf[i].length; j++) {
					HSSFCell cell01 = row.createCell((short)j);
					cell01.setCellValue(xf[i][j]);
				}
			}

			// 新建一输出文件流
			FileOutputStream fOut = new FileOutputStream(outputFile);
			// 把相应的Excel 工作簿存盘
			workbook.write(fOut);
			fOut.flush();
			// 操作结束，关闭文件
			fOut.close();
			System.out.println("文件生成...");
		}
		catch (Exception e) {
			System.out.println("已运行 xlCreate() : " + e);
		}
	}
}