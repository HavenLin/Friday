# Friday
Leetcode trip

# Auto generate a problem by [Leetcode plugin](https://plugins.jetbrains.com/plugin/12132-leetcode-editor)
#### Update Leetcode plugin Template 
#### IDEA -> Preferences -> Tools -> leetcode plugin -> check custom template -> update code template
```
CodeFileName: 
$!velocityTool.camelCaseName(${question.titleSlug})

CodeFileTemplate: 
${question.content}
package leetcode.editor.cn;

public class $!velocityTool.camelCaseName(${question.titleSlug}){
    public static void main(String[] args) {
        Solution solution =  new $!velocityTool.camelCaseName(${question.titleSlug})().new Solution();
    }
    
   ${question.code}
}
```
