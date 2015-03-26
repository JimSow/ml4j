package net.xsoftlab.ml4j.model;

import org.jblas.FloatMatrix;

/**
 * 模型接口
 * 
 * @author 王彦超
 *
 */
public abstract class BaseModel {

	protected FloatMatrix x;// 特征值
	protected FloatMatrix y;// 标签
	protected float lambda = 0f;// 正则化系数

	protected int m;// 样本数量
	protected float cost;// cost
	protected FloatMatrix gradient;// 梯度

	protected float epsilon = 1e-4f;// 梯度校验区间
	protected boolean checkFlag = false;// 梯度校验开关

	/**
	 * 计算梯度/代价(目标)函数
	 * 
	 * @param theta
	 *            参数
	 * @param flag
	 *            1.计算cost 2.计算梯度 3.计算全部
	 * @return 梯度/cost
	 */
	public abstract void compute(FloatMatrix theta, int flag);

	/**
	 * 梯度校验
	 */
	public abstract void checkGradients();

	/**
	 * 准确度评测
	 * 
	 * @param theta
	 *            训练好的theta
	 * @return 准确度
	 */
	public abstract float evaluate(FloatMatrix theta);

	/**
	 * 准确度评测
	 * 
	 * @param theta
	 *            训练好的theta
	 * @param x
	 *            测试集
	 * @param y
	 *            标签
	 * @return 准确度
	 */
	public abstract float evaluate(FloatMatrix theta, FloatMatrix x, FloatMatrix y);

	/**
	 * 获取初始theta值
	 * 
	 * @return theta
	 */
	public abstract FloatMatrix getInitTheta();

	public float getCost() {
		return cost;
	}

	public FloatMatrix getGradient() {
		return gradient;
	}
}
