package journal.com.journalapp.databinding;
import journal.com.journalapp.R;
import journal.com.journalapp.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivitySignUpBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.displayName, 1);
        sViewsWithIds.put(R.id.idnumber, 2);
        sViewsWithIds.put(R.id.emailAddress, 3);
        sViewsWithIds.put(R.id.password, 4);
        sViewsWithIds.put(R.id.gender, 5);
        sViewsWithIds.put(R.id.male, 6);
        sViewsWithIds.put(R.id.female, 7);
        sViewsWithIds.put(R.id.signUp, 8);
        sViewsWithIds.put(R.id.signOut, 9);
    }
    // views
    @NonNull
    public final android.widget.EditText displayName;
    @NonNull
    public final android.widget.EditText emailAddress;
    @NonNull
    public final android.widget.RadioButton female;
    @NonNull
    public final android.widget.RadioGroup gender;
    @NonNull
    public final android.widget.EditText idnumber;
    @NonNull
    public final android.widget.RadioButton male;
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    public final android.widget.EditText password;
    @NonNull
    public final android.widget.Button signOut;
    @NonNull
    public final android.widget.Button signUp;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivitySignUpBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds);
        this.displayName = (android.widget.EditText) bindings[1];
        this.emailAddress = (android.widget.EditText) bindings[3];
        this.female = (android.widget.RadioButton) bindings[7];
        this.gender = (android.widget.RadioGroup) bindings[5];
        this.idnumber = (android.widget.EditText) bindings[2];
        this.male = (android.widget.RadioButton) bindings[6];
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.password = (android.widget.EditText) bindings[4];
        this.signOut = (android.widget.Button) bindings[9];
        this.signUp = (android.widget.Button) bindings[8];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ActivitySignUpBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivitySignUpBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivitySignUpBinding>inflate(inflater, journal.com.journalapp.R.layout.activity_sign__up, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivitySignUpBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivitySignUpBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(journal.com.journalapp.R.layout.activity_sign__up, null, false), bindingComponent);
    }
    @NonNull
    public static ActivitySignUpBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivitySignUpBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_sign__up_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivitySignUpBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}