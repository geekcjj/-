package ${controllerPackage};

import com.maike.common.entity.Result;
import com.maike.common.entity.ResultGenerator;
import ${basePackage}.pojo.${modelNameUpperCamel};
import ${basePackage}.service.${modelNameUpperCamel}Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.maike.beauty.utils.JsonUtil;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

/**
* Created by ${author} on ${date}.
*/
@RestController
@RequestMapping("${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller {
    @Resource
    private ${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

    @PostMapping("/add")
    public Result add(@RequestBody @Valid ${modelNameUpperCamel} ${modelNameLowerCamel},Errors errors) {
        /**
		 * 通过JSR303 验证数据的完整性 若存在错误的的格式则返回前端错误代码提示信息
		 * errors.getFieldErrors()
		 */
		if(errors.hasErrors()){
			return ResultGenerator.genFailResult(JsonUtil.objectToJsonStr(errors.getFieldErrors()));
		}
        ${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id) {
        ${modelNameLowerCamel}Service.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(@RequestBody @Valid ${modelNameUpperCamel} ${modelNameLowerCamel},Errors errors) {
        /**
		 * 通过JSR303 验证数据的完整性 若存在错误的的格式则返回前端错误代码提示信息
		 * errors.getFieldErrors()
		 */
		if(errors.hasErrors()){
			return ResultGenerator.genFailResult(JsonUtil.objectToJsonStr(errors.getFieldErrors()));
		}
        ${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id) {
        ${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
        return ResultGenerator.genSuccessResult(${modelNameLowerCamel});
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        PageHelper.startPage(page, size);
        List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findAll();
        PageInfo<${modelNameUpperCamel}> pageInfo = new PageInfo<>(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
