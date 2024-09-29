// Generated from ImageProcessing.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ImageProcessingParser}.
 */
public interface ImageProcessingListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ImageProcessingParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(ImageProcessingParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImageProcessingParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(ImageProcessingParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImageProcessingParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(ImageProcessingParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImageProcessingParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(ImageProcessingParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImageProcessingParser#loadImage}.
	 * @param ctx the parse tree
	 */
	void enterLoadImage(ImageProcessingParser.LoadImageContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImageProcessingParser#loadImage}.
	 * @param ctx the parse tree
	 */
	void exitLoadImage(ImageProcessingParser.LoadImageContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImageProcessingParser#saveImage}.
	 * @param ctx the parse tree
	 */
	void enterSaveImage(ImageProcessingParser.SaveImageContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImageProcessingParser#saveImage}.
	 * @param ctx the parse tree
	 */
	void exitSaveImage(ImageProcessingParser.SaveImageContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImageProcessingParser#applyFilter}.
	 * @param ctx the parse tree
	 */
	void enterApplyFilter(ImageProcessingParser.ApplyFilterContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImageProcessingParser#applyFilter}.
	 * @param ctx the parse tree
	 */
	void exitApplyFilter(ImageProcessingParser.ApplyFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImageProcessingParser#filterType}.
	 * @param ctx the parse tree
	 */
	void enterFilterType(ImageProcessingParser.FilterTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImageProcessingParser#filterType}.
	 * @param ctx the parse tree
	 */
	void exitFilterType(ImageProcessingParser.FilterTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImageProcessingParser#transform}.
	 * @param ctx the parse tree
	 */
	void enterTransform(ImageProcessingParser.TransformContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImageProcessingParser#transform}.
	 * @param ctx the parse tree
	 */
	void exitTransform(ImageProcessingParser.TransformContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImageProcessingParser#transformation}.
	 * @param ctx the parse tree
	 */
	void enterTransformation(ImageProcessingParser.TransformationContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImageProcessingParser#transformation}.
	 * @param ctx the parse tree
	 */
	void exitTransformation(ImageProcessingParser.TransformationContext ctx);
	/**
	 * Enter a parse tree produced by {@link ImageProcessingParser#transformationValue}.
	 * @param ctx the parse tree
	 */
	void enterTransformationValue(ImageProcessingParser.TransformationValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link ImageProcessingParser#transformationValue}.
	 * @param ctx the parse tree
	 */
	void exitTransformationValue(ImageProcessingParser.TransformationValueContext ctx);
}