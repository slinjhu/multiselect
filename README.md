# multiselect
This is an Android demo to show multiple selection using ListView and CheckedTextView. 

# Notes
1. If you set `layout_height` of the ListView to be `wrap_parent`, then the `setView` method will be called for a lot of time since the actual height needs to be calculated dynamically. Try fixed height or `fill_parent`. 