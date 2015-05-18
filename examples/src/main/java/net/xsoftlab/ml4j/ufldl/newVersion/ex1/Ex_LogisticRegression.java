package net.xsoftlab.ml4j.ufldl.newVersion.ex1;

import java.io.IOException;
import java.util.Map;

import net.xsoftlab.ml4j.model.supervised.BaseModel;
import net.xsoftlab.ml4j.model.supervised.LogisticRegression;
import net.xsoftlab.ml4j.util.MnistLoader;
import net.xsoftlab.ml4j.util.TestUtil;

import org.jblas.FloatMatrix;

public class Ex_LogisticRegression extends TestUtil {

	public static void main(String[] args) throws IOException {

		tic();

		logger.info("加载数据...\n");
		Map<String, FloatMatrix[]> map = MnistLoader.load(true);
		FloatMatrix[] train = map.get("train");
		FloatMatrix[] test = map.get("test");

		logger.info("模型初始化...\n");
		BaseModel model = new LogisticRegression(train[0], train[1]);

		logger.info("执行训练...\n");
		FloatMatrix theta = model.train();

		logger.info("准确度测算...\n");
		float p = model.evaluate(theta);
		float p1 = model.evaluate(theta, test[0], test[1]);

		logger.info("训练完成.\n\t theta = {} \n\t 训练集准确度 = {}% \n\t 测试集准确度 = {}%", new Object[] { theta, p, p1 });

		// ufldl的测试集准确度为100%，而此处为99.95272%
		// 是因为ufldl的程序里进行了%2.1f的输出控制，进行了四舍五入。
		toc();
	}
}